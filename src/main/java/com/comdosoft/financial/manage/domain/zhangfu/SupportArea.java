package com.comdosoft.financial.manage.domain.zhangfu;

public class SupportArea {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column support_areas.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column support_areas.pay_channel_id
	 * @mbggenerated
	 */
	private Integer payChannelId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column support_areas.city_id
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column support_areas.support_type
	 * @mbggenerated
	 */
	private Boolean supportType;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column support_areas.id
	 * @return  the value of support_areas.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column support_areas.id
	 * @param id  the value for support_areas.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column support_areas.pay_channel_id
	 * @return  the value of support_areas.pay_channel_id
	 * @mbggenerated
	 */
	public Integer getPayChannelId() {
		return payChannelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column support_areas.pay_channel_id
	 * @param payChannelId  the value for support_areas.pay_channel_id
	 * @mbggenerated
	 */
	public void setPayChannelId(Integer payChannelId) {
		this.payChannelId = payChannelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column support_areas.city_id
	 * @return  the value of support_areas.city_id
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column support_areas.city_id
	 * @param cityId  the value for support_areas.city_id
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column support_areas.support_type
	 * @return  the value of support_areas.support_type
	 * @mbggenerated
	 */
	public Boolean getSupportType() {
		return supportType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column support_areas.support_type
	 * @param supportType  the value for support_areas.support_type
	 * @mbggenerated
	 */
	public void setSupportType(Boolean supportType) {
		this.supportType = supportType;
	}
}