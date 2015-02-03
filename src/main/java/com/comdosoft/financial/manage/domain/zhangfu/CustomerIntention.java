package com.comdosoft.financial.manage.domain.zhangfu;

public class CustomerIntention {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.process_user_id
	 * @mbggenerated
	 */
	private Integer processUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.intention_name
	 * @mbggenerated
	 */
	private String intentionName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.intention_phone
	 * @mbggenerated
	 */
	private String intentionPhone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.status
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.intention_marks_id
	 * @mbggenerated
	 */
	private Integer intentionMarksId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column customer_intentions.content
	 * @mbggenerated
	 */
	private String content;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.id
	 * @return  the value of customer_intentions.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.id
	 * @param id  the value for customer_intentions.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.process_user_id
	 * @return  the value of customer_intentions.process_user_id
	 * @mbggenerated
	 */
	public Integer getProcessUserId() {
		return processUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.process_user_id
	 * @param processUserId  the value for customer_intentions.process_user_id
	 * @mbggenerated
	 */
	public void setProcessUserId(Integer processUserId) {
		this.processUserId = processUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.intention_name
	 * @return  the value of customer_intentions.intention_name
	 * @mbggenerated
	 */
	public String getIntentionName() {
		return intentionName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.intention_name
	 * @param intentionName  the value for customer_intentions.intention_name
	 * @mbggenerated
	 */
	public void setIntentionName(String intentionName) {
		this.intentionName = intentionName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.intention_phone
	 * @return  the value of customer_intentions.intention_phone
	 * @mbggenerated
	 */
	public String getIntentionPhone() {
		return intentionPhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.intention_phone
	 * @param intentionPhone  the value for customer_intentions.intention_phone
	 * @mbggenerated
	 */
	public void setIntentionPhone(String intentionPhone) {
		this.intentionPhone = intentionPhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.status
	 * @return  the value of customer_intentions.status
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.status
	 * @param status  the value for customer_intentions.status
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.intention_marks_id
	 * @return  the value of customer_intentions.intention_marks_id
	 * @mbggenerated
	 */
	public Integer getIntentionMarksId() {
		return intentionMarksId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.intention_marks_id
	 * @param intentionMarksId  the value for customer_intentions.intention_marks_id
	 * @mbggenerated
	 */
	public void setIntentionMarksId(Integer intentionMarksId) {
		this.intentionMarksId = intentionMarksId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column customer_intentions.content
	 * @return  the value of customer_intentions.content
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column customer_intentions.content
	 * @param content  the value for customer_intentions.content
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content;
	}
}