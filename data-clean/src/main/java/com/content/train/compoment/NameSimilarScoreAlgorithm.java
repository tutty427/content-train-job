package com.content.train.compoment;

import com.content.train.dto.train.TitleSimilarAble;
import com.content.train.utils.WordSegmentor;

import java.util.*;

/**
 * Created by shawxy on 8/11/16.
 */
public class NameSimilarScoreAlgorithm implements Algorithm<TitleSimilarAble,Double>{

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
    private double calculateSimiScore(Map<String, Integer> wordSegmentA, Map<String, Integer> wordSegmentB) {


        if(wordSegmentA == null || wordSegmentB == null ||wordSegmentA.isEmpty() || wordSegmentB.isEmpty() ) return 0;

        double abSum = 0;
        Iterator<Map.Entry<String, Integer>> it = wordSegmentA.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (wordSegmentB.containsKey(entry.getKey())) {
                //计算分子
                abSum += (entry.getValue() * wordSegmentB.get(entry.getKey()));
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
        for (int f : freq) {
            sum += Math.pow(f, 2);
        }
        return Math.sqrt(sum);
    }



    public Double action(TitleSimilarAble source, TitleSimilarAble target) {

        if(source.getTargetTitleId() == target.getTargetTitleId()){
            return 0D; //in case
        }

        double score  = calculateSimiScore(splitWord(source.getTargetTitle()), splitWord(target.getTargetTitle()));
        return score;
    }
}
