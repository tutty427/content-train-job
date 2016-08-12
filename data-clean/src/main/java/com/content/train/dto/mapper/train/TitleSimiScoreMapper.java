package com.content.train.dto.mapper.train;

import com.content.train.dto.train.TitleSimiScore;

import java.util.List;

public interface TitleSimiScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     */
    int insert(TitleSimiScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     */
    int insertSelective(TitleSimiScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     */
    TitleSimiScore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     *
    int updateByPrimaryKeySelective(TitleSimiScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table title_simi_score
     *
     * @mbggenerated Thu Aug 11 15:18:43 CST 2016
     */
    int updateByPrimaryKey(TitleSimiScore record);

    void insertBatch(List<TitleSimiScore > record);
}