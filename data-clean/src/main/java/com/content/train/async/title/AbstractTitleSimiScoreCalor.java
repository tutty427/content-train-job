package com.content.train.async.title;

import com.content.train.compoment.Algorithm;
import com.content.train.dto.train.TitleSimiScore;
import com.content.train.dto.train.TitleSimilarAble;
import com.content.train.service.Trainee;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by shawxy on 8/11/16.
 */
public abstract class AbstractTitleSimiScoreCalor<D,T,S extends TitleSimilarAble> implements Calculator {

    private T dbMapper;

    private D scoreMapper;

    private Algorithm algorithm;

    public void setMapper(T mapper){
        this.dbMapper = mapper;
    }

    public void setScoreMapper(D mapper){
        this.scoreMapper = mapper;
    }

    public void setAlgorithm(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void excute() {

        int index = 0;
        int rangeFirstId = 0;
        int maxId = getMaxIdFromDB(dbMapper);
        for(;;) {

            if(index >= maxId ){
                break;
            }

            S sourceObj = getSourceObject(dbMapper,index);
            if(sourceObj == null){
                index++;
                continue;
            }

            for(;;){
                if(rangeFirstId >= maxId ){
                    index++;
                    rangeFirstId = 0;
                    break;
                };

                List targets = getTargetRange(dbMapper, rangeFirstId);
                if(CollectionUtils.isEmpty(targets)){
                    rangeFirstId+=PAGE_SIZE;
                    continue;
                }

                //calculate and store into DB
                List<TitleSimiScore> list = Lists.newArrayList();
                for(TitleSimilarAble titleSimilarAble : (List<TitleSimilarAble>)targets){

                    double score  = (Double)algorithm.action(sourceObj,titleSimilarAble);
                    if(score == 0) continue;
                    TitleSimiScore titleSimiScore = new TitleSimiScore();
                    titleSimiScore.setTitleIdA(sourceObj.getBehaviorId());
                    titleSimiScore.setTitleIdB(titleSimilarAble.getBehaviorId());
                    titleSimiScore.setAddTime(new Date());
                    titleSimiScore.setScore(score);
                    list.add(titleSimiScore);

                    if(list.size() == 100){
                        storeToDB(scoreMapper,list);
                        list.clear();
                        continue;
                    }
                }

                if(!CollectionUtils.isEmpty(list)){
                    storeToDB(scoreMapper, list);
                }

                rangeFirstId = refreshRangeFirstId(targets);
            }

        }





    }


    public abstract S getSourceObject(T mapper, int index);

    public abstract int getMaxIdFromDB(T mapper);

    public abstract void storeToDB(D mapper , List data);

    public abstract List<S> getTargetRange(T mapper, int firstId);

    private int refreshRangeFirstId(List<S> targets){
        return targets.get(targets.size()-1).getTargetTitleId();
    }

}
