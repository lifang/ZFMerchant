package com.comdosoft.financial.user.domain.zhangfu;

import java.util.Date;

public class DictionaryTradeStandardRate {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.merchant_type_name
	 * @mbggenerated
	 */
	private String merchantTypeName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.base_rate
	 * @mbggenerated
	 */
	private String baseRate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.description
	 * @mbggenerated
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.created_at
	 * @mbggenerated
	 */
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_trade_standard_rates.updated_at
	 * @mbggenerated
	 */
	private Date updatedAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.id
	 * @return  the value of dictionary_trade_standard_rates.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.id
	 * @param id  the value for dictionary_trade_standard_rates.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.merchant_type_name
	 * @return  the value of dictionary_trade_standard_rates.merchant_type_name
	 * @mbggenerated
	 */
	public String getMerchantTypeName() {
		return merchantTypeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.merchant_type_name
	 * @param merchantTypeName  the value for dictionary_trade_standard_rates.merchant_type_name
	 * @mbggenerated
	 */
	public void setMerchantTypeName(String merchantTypeName) {
		this.merchantTypeName = merchantTypeName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.base_rate
	 * @return  the value of dictionary_trade_standard_rates.base_rate
	 * @mbggenerated
	 */
	public String getBaseRate() {
		return baseRate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.base_rate
	 * @param baseRate  the value for dictionary_trade_standard_rates.base_rate
	 * @mbggenerated
	 */
	public void setBaseRate(String baseRate) {
		this.baseRate = baseRate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.description
	 * @return  the value of dictionary_trade_standard_rates.description
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.description
	 * @param description  the value for dictionary_trade_standard_rates.description
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.created_at
	 * @return  the value of dictionary_trade_standard_rates.created_at
	 * @mbggenerated
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.created_at
	 * @param createdAt  the value for dictionary_trade_standard_rates.created_at
	 * @mbggenerated
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_trade_standard_rates.updated_at
	 * @return  the value of dictionary_trade_standard_rates.updated_at
	 * @mbggenerated
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_trade_standard_rates.updated_at
	 * @param updatedAt  the value for dictionary_trade_standard_rates.updated_at
	 * @mbggenerated
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}