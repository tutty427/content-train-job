package com.content.train.async.title;

import com.content.train.dto.mapper.train.ChanYouJiMapper;
import com.content.train.dto.mapper.train.TitleSimiScoreMapper;
import com.content.train.dto.train.ChanYouJi;

import java.util.List;

/**
 * Created by shawxy on 8/12/16.
 */
public class ChanYouJiCalculateJob extends AbstractTitleSimiScoreCalor<TitleSimiScoreMapper,ChanYouJiMapper,ChanYouJi>  {


    @Override
    public ChanYouJi getSourceObject(ChanYouJiMapper mapper, int index) {
        return mapper.selectByPrimaryKey(index);
    }

    @Override
    public int getMaxIdFromDB(ChanYouJiMapper mapper) {
        return mapper.getMaxId();
    }

    @Override
    public void storeToDB(TitleSimiScoreMapper mapper, List data) {
        mapper.insertBatch(data);
    }

    @Override
    public List<ChanYouJi> getTargetRange(ChanYouJiMapper mapper, int firstId) {
        return mapper.selectByRange(firstId,Calculator.PAGE_SIZE);
    }
}
