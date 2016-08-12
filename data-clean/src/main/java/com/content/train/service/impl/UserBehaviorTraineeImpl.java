package com.content.train.service.impl;

import com.content.train.dto.train.ContentUserCount;
import com.content.train.dto.train.ItemSimiScore;
import com.content.train.dto.train.TitleSimilarAble;
import com.content.train.enums.BehaviorType;
import com.content.train.service.BaseService;
import com.content.train.service.Trainee;
import com.content.train.utils.BizLogicHandler;
import com.content.train.utils.PaginationHandler;
import com.content.train.vo.UserBehaviorVo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by shawxy on 8/9/16.
 *
 * 根据用户行为，挖掘item关联关系
 *
 * 1. item-user 反向关系表
 * 2. S(i,j)= U(i)|U(j)/U(i)&U(j)
 */
public class UserBehaviorTraineeImpl extends BaseService implements Trainee {


    private Map<String,Set<Integer>> itemPositiveUserIdMap = Maps.newHashMap();
    private Map<String,Set<Integer>> itemNegativeUserIdMap = Maps.newHashMap();




    public void doTraining() {

        makeReverseDataTable();
        calculateSimiScore();

    }


    //加载样本数据
    private void init(){

        //采集用户behavior数据，目前限定4大类型JOKE,CHANYOUJI,MIAOPAI,SMSDM
        //保证用户行为的趋势性，只取相隔1个月的数据？ 测试数据量级太小... 提高数据采集间隔？
        List<UserBehaviorVo> userBehaviorVos =  new PaginationHandler<Integer,Integer,UserBehaviorVo>(0,3000,0, new BizLogicHandler<Integer,Integer,UserBehaviorVo>() {

            public List<UserBehaviorVo> handle(Integer maxCompareEle, int pageSize, Integer conditions) {
                return  userBehaviorMapper.selectAllEffectiveBehaviorVo(maxCompareEle,pageSize);
            }
            public Integer getMaxCompareEle(Integer maxCompareEle, List<UserBehaviorVo> subResult) {
                return subResult.get(subResult.size()-1).getId();
            }
        }).execute();


        //根据behavior_type对数据分类
        for(UserBehaviorVo vo : userBehaviorVos){
            String bType = vo.getBehaviorType();
            if(Strings.isNullOrEmpty(bType)){
                continue;
            }
            if(BehaviorType.isPositiveBehavior(Integer.valueOf(bType.trim()))){
                Set<Integer> usrIds = itemPositiveUserIdMap.get(vo.getBehaviorContent());
                if(CollectionUtils.isEmpty(usrIds)){
                    usrIds = Sets.newHashSet();
                }
                usrIds.add(vo.getUserId());
                itemPositiveUserIdMap.put(vo.getBehaviorContent(), usrIds);
                continue;
            }
            Set<Integer> ngUsrIds = itemNegativeUserIdMap.get(vo.getBehaviorContent());
            if(CollectionUtils.isEmpty(ngUsrIds)){
                ngUsrIds = Sets.newHashSet();
            }
            ngUsrIds.add(vo.getUserId());
            itemNegativeUserIdMap.put(vo.getBehaviorContent(), ngUsrIds);
        }

    }




    private void makeReverseDataTable() {


        init();

        //过滤掉消极操作
        Iterator iterator = itemPositiveUserIdMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,Set<Integer>> entry = (Map.Entry<String,Set<Integer>>) iterator.next();
            String key = entry.getKey();

            Set<Integer> ngUserIdSet = itemNegativeUserIdMap.get(key);
            if(CollectionUtils.isEmpty(ngUserIdSet)){
                continue;
            }

            Set<Integer> posUserIdSet = entry.getValue();
            posUserIdSet.removeAll(ngUserIdSet);
            itemPositiveUserIdMap.put(key, posUserIdSet);
        }

        //存DB
        storeToDB();

    }






    //储存反向表
    private void storeToDB(){


        Date now = new Date();

        List<ContentUserCount> pendingToDB = Lists.newArrayList();
        Iterator iterator = itemPositiveUserIdMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,Set<Integer>> entry = (Map.Entry<String,Set<Integer>>) iterator.next();
            String key = entry.getKey();
            Set<Integer> userIdSet =  entry.getValue();
            if(CollectionUtils.isEmpty(userIdSet)){
                continue;
            }
            ContentUserCount contentUserCount = new ContentUserCount();
            contentUserCount.setBehaviorContent(key);
            contentUserCount.setUserIdJson(new Gson().toJson(userIdSet));
            contentUserCount.setAddTime(now);
            pendingToDB.add(contentUserCount);

            if(pendingToDB.size() == 100){
                contentUserCountMapper.insertBatch(pendingToDB);
                pendingToDB.clear();
                continue;
            }

        }
        if(!CollectionUtils.isEmpty(pendingToDB)){
            contentUserCountMapper.insertBatch(pendingToDB);

        }
    }





    public void calculateSimiScore() {

        Date now = new Date();
        List<ContentUserCount> all = contentUserCountMapper.getAll();
        for(int i = 0 ; i < all.size(); i++){

            ContentUserCount contentUserCount = all.get(i);

            for(int j = all.size()-1 ; j > i ; j--){

                double score = doCalaulate(contentUserCount, all.get(j));
                if(score == 0){
                    continue;
                }

                ItemSimiScore itemSimiScore = new ItemSimiScore();
                itemSimiScore.setAddDate(now);
                itemSimiScore.setItemId(contentUserCount.getBehaviorContent());
                itemSimiScore.setTargetItemId(all.get(j).getBehaviorContent());
                itemSimiScore.setScore(Double.valueOf(score));
                itemSimiScoreMapper.insert(itemSimiScore);

            }
        }
    }




    private double doCalaulate(ContentUserCount a , ContentUserCount b){

        List<Double> aList =  new Gson().fromJson(a.getUserIdJson(),ArrayList.class);
        List<Double> bList =  new Gson().fromJson(b.getUserIdJson(), ArrayList.class);

        //2个样本当且仅当被同一个用户关注过，相似度不可靠，返回0
        if(aList.size() == 1 && bList.size() == 1){
            if(aList.get(0).equals(bList.get(0))){
                return 0;
            }
        }


        int intersection = 0;
        for(Double userId : aList){

            if(bList.contains(userId)){
                intersection++;
            }else{
                bList.add(userId);
            }

        }

        //需要降低活跃用户对相似度计算的影响 todo
        double score = (double)intersection/Math.sqrt(aList.size() * bList.size());
        return score;
    }

    public double doTraining(TitleSimilarAble target, TitleSimilarAble source) {
        return 0;
    }
}
