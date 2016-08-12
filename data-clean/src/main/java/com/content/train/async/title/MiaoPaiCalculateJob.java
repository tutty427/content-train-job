package com.content.train.async.title;

import com.content.train.dto.mapper.train.ChanYouJiMapper;
import com.content.train.dto.mapper.train.MiaoPaiVideoMapper;
import com.content.train.dto.mapper.train.TitleSimiScoreMapper;
import com.content.train.dto.train.ChanYouJi;
import com.content.train.dto.train.MiaoPaiVideo;

import java.util.List;

/**
 * Created by shawxy on 8/12/16.
 */
public class MiaoPaiCalculateJob extends AbstractTitleSimiScoreCalor<TitleSimiScoreMapper,MiaoPaiVideoMapper,MiaoPaiVideo>  {

    @Override
    public MiaoPaiVideo getSourceObject(MiaoPaiVideoMapper mapper, int index) {

        return mapper.selectByPrimaryKey(index);
    }

    @Override
    public int getMaxIdFromDB(MiaoPaiVideoMapper mapper) {
        return mapper.getMaxId();
    }

    @Override
    public void storeToDB(TitleSimiScoreMapper mapper, List data) {
        mapper.insertBatch(data);
    }

    @Override
    public List<MiaoPaiVideo> getTargetRange(MiaoPaiVideoMapper mapper, int firstId) {
        return mapper.selectByRange(firstId,Calculator.PAGE_SIZE);
    }
}
