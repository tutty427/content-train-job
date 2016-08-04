package com.content.train.utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shawxy on 8/4/16
 */
public class WordSegmentor {



    public static List<String> splitToWords(String title,boolean bsmart) throws IOException {
        if (title == null || title.trim().length() < 1) {
            return null;
        }
        title = title.toLowerCase();

        //把特殊字符替换成空串
        title = title.replaceAll("[（‘`'&）-]", "");

        List<String> tokens = new ArrayList<String>();

        StringReader reader = new StringReader(title);
        IKSegmenter ik = new IKSegmenter(reader, bsmart);// 当为true时，分词器进行最大词长切分
        Lexeme lexeme ;
        while ((lexeme = ik.next()) != null) {
            tokens.add(lexeme.getLexemeText());
        }

        return tokens;

    }

}
