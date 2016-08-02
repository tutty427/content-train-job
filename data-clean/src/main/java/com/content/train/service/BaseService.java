package com.content.train.service;

import com.content.train.dto.mapper.train.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shawxy on 8/2/16.
 */
public abstract class BaseService {

    public BaiduJokeMapper baiduJokeMapper;
    public ChanYouJiMapper chanYouJiMapper;
    public MiaoPaiVideoMapper miaoPaiVideoMapper;
    public SmZdmMapper smZdmMapper;
    public UserBehaviorMapper userBehaviorMapper;
    public ContentUserCountMapper contentUserCountMapper;


    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext_connection.xml");
        baiduJokeMapper = (BaiduJokeMapper)context.getBean("baiduJokeMapper");
        chanYouJiMapper = (ChanYouJiMapper)context.getBean("chanYouJiMapper");
        miaoPaiVideoMapper = (MiaoPaiVideoMapper)context.getBean("miaoPaiVideoMapper");
        smZdmMapper = (SmZdmMapper)context.getBean("smZdmMapper");
        userBehaviorMapper = (UserBehaviorMapper)context.getBean("userBehaviorMapper");
        contentUserCountMapper = (ContentUserCountMapper)context.getBean("contentUserCountMapper");

    }

}
