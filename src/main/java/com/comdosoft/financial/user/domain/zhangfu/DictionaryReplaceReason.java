package com.comdosoft.financial.user.domain.zhangfu;

import java.util.Date;

public class DictionaryReplaceReason {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_replace_reasons.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_replace_reasons.replace_reason
	 * @mbggenerated
	 */
	private String replaceReason;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dictionary_replace_reasons.created_at
	 * @mbggenerated
	 */
	private Date createdAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_replace_reasons.id
	 * @return  the value of dictionary_replace_reasons.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_replace_reasons.id
	 * @param id  the value for dictionary_replace_reasons.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_replace_reasons.replace_reason
	 * @return  the value of dictionary_replace_reasons.replace_reason
	 * @mbggenerated
	 */
	public String getReplaceReason() {
		return replaceReason;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_replace_reasons.replace_reason
	 * @param replaceReason  the value for dictionary_replace_reasons.replace_reason
	 * @mbggenerated
	 */
	public void setReplaceReason(String replaceReason) {
		this.replaceReason = replaceReason;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dictionary_replace_reasons.created_at
	 * @return  the value of dictionary_replace_reasons.created_at
	 * @mbggenerated
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dictionary_replace_reasons.created_at
	 * @param createdAt  the value for dictionary_replace_reasons.created_at
	 * @mbggenerated
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}