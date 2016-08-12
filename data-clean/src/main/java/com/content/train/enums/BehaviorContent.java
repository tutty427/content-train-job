package com.content.train.enums;

/**
 * Created by shawxy on 8/9/16.
 */
public enum BehaviorContent {




//    yxtk_works   + _ + id 类型：表示用户的作品类型，id为xx的那条数据，分享用户作品的动作
//    works_detail + _ + id 类型：表示用户查看别人发布的作品的详情页，对应id为xx的那条数据 ， 查看详情的动作
//    joke_baidu   + _ + id 类型：表示我们抓取的百度笑话库中的笑话类型，id为xx的那条数据
//    beauty_pictures   + _ + id 类型：表示美女图片类型中，id为xx的那条数据
//    video_miaopai   + _ + id 类型：表示秒拍的视频类型中，id为xx的那条数据
//    news_shop + _ + id 类型：表示购物类的（什么值得买）的商品类型中，id为xx的那条数据
//    其他如：news_monandbaby + _ + id 类型均是对应数据库中的对应id数据

    JOKE("joke_baidu_"),
    MIAO_PAI("video_miaopai_"),
    TRIP("news_trip_"),
    SMZDM("news_shop_")

    ;



    private String dbPrefix;
    BehaviorContent(String dbPrefix){

        this.dbPrefix = dbPrefix;
    }


    public String getPrefix(){
        return dbPrefix;
    }




}
