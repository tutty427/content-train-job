package com.content.train.dto.train;

import java.util.Date;
import lombok.Data;

@Data
public class UserBehavior {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.creator
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.modifier
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.create_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.modify_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.is_deleted
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.user_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.behavior_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private Date behaviorTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.behavior_type
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String behaviorType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.behavior_content
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String behaviorContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.device_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String deviceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.isp
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String isp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.network
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String network;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.longitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.latitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column yxtk_user_behavior.remark
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.id
     *
     * @return the value of yxtk_user_behavior.id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.id
     *
     * @param id the value for yxtk_user_behavior.id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.creator
     *
     * @return the value of yxtk_user_behavior.creator
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.creator
     *
     * @param creator the value for yxtk_user_behavior.creator
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.modifier
     *
     * @return the value of yxtk_user_behavior.modifier
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.modifier
     *
     * @param modifier the value for yxtk_user_behavior.modifier
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.create_time
     *
     * @return the value of yxtk_user_behavior.create_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.create_time
     *
     * @param createTime the value for yxtk_user_behavior.create_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.modify_time
     *
     * @return the value of yxtk_user_behavior.modify_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.modify_time
     *
     * @param modifyTime the value for yxtk_user_behavior.modify_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.is_deleted
     *
     * @return the value of yxtk_user_behavior.is_deleted
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.is_deleted
     *
     * @param isDeleted the value for yxtk_user_behavior.is_deleted
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.user_id
     *
     * @return the value of yxtk_user_behavior.user_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.user_id
     *
     * @param userId the value for yxtk_user_behavior.user_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.behavior_time
     *
     * @return the value of yxtk_user_behavior.behavior_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public Date getBehaviorTime() {
        return behaviorTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.behavior_time
     *
     * @param behaviorTime the value for yxtk_user_behavior.behavior_time
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setBehaviorTime(Date behaviorTime) {
        this.behaviorTime = behaviorTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.behavior_type
     *
     * @return the value of yxtk_user_behavior.behavior_type
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getBehaviorType() {
        return behaviorType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.behavior_type
     *
     * @param behaviorType the value for yxtk_user_behavior.behavior_type
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.behavior_content
     *
     * @return the value of yxtk_user_behavior.behavior_content
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getBehaviorContent() {
        return behaviorContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.behavior_content
     *
     * @param behaviorContent the value for yxtk_user_behavior.behavior_content
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setBehaviorContent(String behaviorContent) {
        this.behaviorContent = behaviorContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.device_id
     *
     * @return the value of yxtk_user_behavior.device_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.device_id
     *
     * @param deviceId the value for yxtk_user_behavior.device_id
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.isp
     *
     * @return the value of yxtk_user_behavior.isp
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getIsp() {
        return isp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.isp
     *
     * @param isp the value for yxtk_user_behavior.isp
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.network
     *
     * @return the value of yxtk_user_behavior.network
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getNetwork() {
        return network;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.network
     *
     * @param network the value for yxtk_user_behavior.network
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.longitude
     *
     * @return the value of yxtk_user_behavior.longitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.longitude
     *
     * @param longitude the value for yxtk_user_behavior.longitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.latitude
     *
     * @return the value of yxtk_user_behavior.latitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.latitude
     *
     * @param latitude the value for yxtk_user_behavior.latitude
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column yxtk_user_behavior.remark
     *
     * @return the value of yxtk_user_behavior.remark
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column yxtk_user_behavior.remark
     *
     * @param remark the value for yxtk_user_behavior.remark
     *
     * @mbggenerated Tue Aug 02 17:37:27 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}