package com.content.train.service.impl;

import com.content.train.service.BaseService;
import com.content.train.service.Trainee;
import com.content.train.utils.WordSegmentor;
import org.junit.Test;

import java.util.List;

/**
 * Created by shawxy on 8/4/16.
 *
 * 对标题进行分词，建向项量模型，利用cos定律计算title相似度
 * 挖出特征词分类？直达词匹配？
 */
public class ContentTraineeImpl extends BaseService implements Trainee {




    @Test
    public void test(){

        System.out.println(splitWord("他说的是车"));

    }






    private List<String> splitWord(String title) {
        try {
            List<String> terms = WordSegmentor.splitToWords(title, true);
            return terms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }








}




