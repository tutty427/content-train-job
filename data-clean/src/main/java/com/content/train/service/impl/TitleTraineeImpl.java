package com.content.train.service.impl;

import com.content.train.async.title.*;
import com.content.train.compoment.NameSimilarScoreAlgorithm;
import com.content.train.dto.mapper.train.MiaoPaiVideoMapper;
import com.content.train.dto.train.BaiduJoke;
import com.content.train.service.BaseService;
import com.content.train.service.Trainee;
import org.junit.Test;


/**
 * Created by shawxy on 8/4/16.
 *
 * 对标题进行分词，建向项量模型，利用cos定律计算title相似度／Jaccard相似度
 * 挖出特征词分类？直达词匹配？
 * simhash？http://www.lanceyan.com/tech/arch/simhash_hamming_distance_similarity.html
 *
 * Elasticsearch能达到相同的作用。。。效率肯定比自己实现好
 */

public class TitleTraineeImpl extends BaseService implements Trainee {



    @Test
    public void doTraining() {




        JokeCalculateJob jokeCalculateJob = new JokeCalculateJob();
        jokeCalculateJob.setMapper(baiduJokeMapper);
        jokeCalculateJob.setScoreMapper(titleSimiScoreMapper);
        jokeCalculateJob.setAlgorithm(new NameSimilarScoreAlgorithm());

        ChanYouJiCalculateJob chanYouJiCalculateJob = new ChanYouJiCalculateJob();
        chanYouJiCalculateJob.setMapper(chanYouJiMapper);
        chanYouJiCalculateJob.setScoreMapper(titleSimiScoreMapper);
        chanYouJiCalculateJob.setAlgorithm(new NameSimilarScoreAlgorithm());

        MiaoPaiCalculateJob miaoPaiCalculateJob = new MiaoPaiCalculateJob();
        miaoPaiCalculateJob.setScoreMapper(titleSimiScoreMapper);
        miaoPaiCalculateJob.setAlgorithm(new NameSimilarScoreAlgorithm());
        miaoPaiCalculateJob.setMapper(miaoPaiVideoMapper);

        SmZdmCalculateJob smZdmCalculateJob = new SmZdmCalculateJob();
        smZdmCalculateJob.setScoreMapper(titleSimiScoreMapper);
        smZdmCalculateJob.setAlgorithm(new NameSimilarScoreAlgorithm());
        smZdmCalculateJob.setMapper(smZdmMapper);

        AsyncJobWorker worker1 = new AsyncJobWorker(jokeCalculateJob);
        AsyncJobWorker worker2 = new AsyncJobWorker(chanYouJiCalculateJob);
        AsyncJobWorker worker3 = new AsyncJobWorker(miaoPaiCalculateJob);
        AsyncJobWorker worker4 = new AsyncJobWorker(smZdmCalculateJob);

        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
        worker4.doWork();
       // jokeCalculateJob.excute();

    }



}


