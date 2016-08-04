package com.content.train.service.impl;

import com.content.train.dto.train.ContentUserCount;
import com.content.train.dto.train.ItemSimiScore;
import com.content.train.enums.BehaviorType;
import com.content.train.service.BaseService;
import com.content.train.service.Cleaner;
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
 * Created by shawxy on 8/2/16.
 * 数据清洗，算法测试
 */
public class CleanerImpl extends BaseService implements Cleaner {


    Map<String,Set<Integer>> itemPositiveUserIdMap = Maps.newHashMap();
    Map<String,Set<Integer>> itemNegativeUserIdMap = Maps.newHashMap();


    @Test
    public void test(){
        makeReverseDataTable();
    }



    //加载样本数据
    private void init(){


        List<UserBehaviorVo> userBehaviorVos = userBehaviorMapper.selectAllEffectiveBehaviorVo();
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



    private void storeToDB(){


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


    public void makeReverseDataTable() {


        init();
        System.out.println(itemPositiveUserIdMap.size());
        System.out.println(itemNegativeUserIdMap.size());


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


        storeToDB();

    }

    @Test
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
        List<Double> bList =  new Gson().fromJson(b.getUserIdJson(),ArrayList.class);

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
}
