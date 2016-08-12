package com.content.train.async.title;

import com.content.train.dto.mapper.train.BaiduJokeMapper;
import com.content.train.dto.mapper.train.TitleSimiScoreMapper;
import com.content.train.dto.train.BaiduJoke;

import java.util.List;

/**
 * Created by shawxy on 8/11/16.
 */
public class JokeCalculateJob extends AbstractTitleSimiScoreCalor<TitleSimiScoreMapper,BaiduJokeMapper,BaiduJoke> {


    @Override
    public BaiduJoke getSourceObject(BaiduJokeMapper mapper, int index) {

        return mapper.selectByPrimaryKey(index);
    }

    @Override
    public int getMaxIdFromDB(BaiduJokeMapper mapper) {

        return mapper.getMaxId();
    }

    @Override
    public void storeToDB(TitleSimiScoreMapper mapper, List data) {

        mapper.insertBatch(data);
    }

    @Override
    public List<BaiduJoke> getTargetRange(BaiduJokeMapper mapper, int firstId) {
        return mapper.selectByRange(firstId,Calculator.PAGE_SIZE);
    }

}
