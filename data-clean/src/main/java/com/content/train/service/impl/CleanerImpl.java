package com.content.train.service.impl;

import com.content.train.dto.mapper.train.ContentUserCountMapper;
import com.content.train.dto.train.ContentUserCount;
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
 */
public class CleanerImpl extends BaseService implements Cleaner {


    Map<String,Set<Integer>> itemPositiveUserIdMap = Maps.newHashMap();
    Map<String,Set<Integer>> itemNegativeUserIdMap = Maps.newHashMap();


    @Test
    public void test(){
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
            itemPositiveUserIdMap.put(key,posUserIdSet);
        }


        storeToDB();

    }



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




}
