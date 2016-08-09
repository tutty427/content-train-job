package com.content.train.utils;

import com.google.common.collect.Maps;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

/**
 * Created by shawxy on 8/4/16
 */
public class WordSegmentor {



    public static Map<String, Integer> splitToWords(String title,boolean bsmart) throws IOException {
        if (title == null || title.trim().length() < 1) {
            return null;
        }
        title = title.toLowerCase();

        //把特殊字符替换成空串
        title = title.replaceAll("[（‘`'&）-]", "");


        Map<String, Integer> wordFreq = Maps.newHashMap();

        StringReader reader = new StringReader(title);
        IKSegmenter ik = new IKSegmenter(reader, bsmart);// 当为true时，分词器进行最大词长切分
        Lexeme lexeme ;
        while ((lexeme = ik.next()) != null) {
            if(!wordFreq.containsKey(lexeme.getLexemeText())) {
                wordFreq.put(lexeme.getLexemeText(), 1);
                continue;
            }

            int freq = wordFreq.get(lexeme.getLexemeText());
            wordFreq.put(lexeme.getLexemeText(), ++freq);
        }

        return wordFreq;

    }

}
