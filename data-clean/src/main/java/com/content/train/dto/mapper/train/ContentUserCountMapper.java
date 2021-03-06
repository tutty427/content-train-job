package com.content.train.dto.mapper.train;

import com.content.train.dto.train.ContentUserCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentUserCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int insert(ContentUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int insertSelective(ContentUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    ContentUserCount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int updateByPrimaryKeySelective(ContentUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(ContentUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table content_user_count
     *
     * @mbggenerated Tue Aug 02 22:59:58 CST 2016
     */
    int updateByPrimaryKey(ContentUserCount record);


    int insertBatch(@Param("data") List<ContentUserCount> record);

    List<ContentUserCount> getAll();

}