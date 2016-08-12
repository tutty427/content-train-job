package com.content.train.async.title;

import com.content.train.dto.mapper.train.MiaoPaiVideoMapper;
import com.content.train.dto.mapper.train.SmZdmMapper;
import com.content.train.dto.mapper.train.TitleSimiScoreMapper;
import com.content.train.dto.train.MiaoPaiVideo;
import com.content.train.dto.train.SmZdm;

import java.util.List;

/**
 * Created by shawxy on 8/12/16.
 */
public class SmZdmCalculateJob extends AbstractTitleSimiScoreCalor<TitleSimiScoreMapper,SmZdmMapper,SmZdm>  {
    @Override
    public SmZdm getSourceObject(SmZdmMapper mapper, int index) {
        return mapper.selectByPrimaryKey(index);
    }

    @Override
    public int getMaxIdFromDB(SmZdmMapper mapper) {
        return mapper.getMaxId();
    }

    @Override
    public void storeToDB(TitleSimiScoreMapper mapper, List data) {
        mapper.insertBatch(data);
    }

    @Override
    public List<SmZdm> getTargetRange(SmZdmMapper mapper, int firstId) {
        return mapper.selectByRange(firstId,Calculator.PAGE_SIZE);
    }
}
