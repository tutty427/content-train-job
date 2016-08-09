package com.content.train.service.impl;

import com.content.train.service.BaseService;
import com.content.train.service.Trainee;
import com.content.train.utils.WordSegmentor;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shawxy on 8/4/16.
 *
 * 对标题进行分词，建向项量模型，利用cos定律计算title相似度／Jaccard相似度
 * 挖出特征词分类？直达词匹配？
 * simhash？http://www.lanceyan.com/tech/arch/simhash_hamming_distance_similarity.html
 */
public class ContentTraineeImpl extends BaseService implements Trainee {


    @Test
    public void test(){

        //System.out.println(splitWord("尼玛还有这样的同事"));
        //System.out.println(splitWord("给他干女儿辅导辅导功课"));
        System.out.println(calculateSimiScore(splitWord("老婆对我最好了"), splitWord("老婆抱着一个男的在睡觉")));
    }

    //对title进行分词 ，过滤停顿次，得到单词与词频map
    private Map<String, Integer> splitWord(String title) {
        try {
            Map<String, Integer> terms = WordSegmentor.splitToWords(title, true);
            return terms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    //计算相似度
    public double calculateSimiScore(Map<String, Integer> wordSegmentA , Map<String, Integer> wordSegmentB){


        double abSum = 0;
        Iterator<Map.Entry<String, Integer>> it = wordSegmentA.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Integer> entry = it.next();
            if(wordSegmentB.containsKey(entry.getKey())) {
                //计算分子
                abSum += ( entry.getValue() * wordSegmentB.get(entry.getKey()));
            }
        }

        double aPowSum = powSum(wordSegmentA);
        double bPowSum = powSum(wordSegmentB);

        return abSum / (aPowSum * bPowSum);


    }

    //计算分母
    private double powSum(Map<String, Integer> wordSegmentA) {
        Collection<Integer> freq = wordSegmentA.values();
        double sum = 0;
        for(int f : freq) {
            sum += Math.pow(f, 2);
        }
        return Math.sqrt(sum);
    }



}




