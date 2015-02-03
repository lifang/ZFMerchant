package com.comdosoft.financial.manage.domain.zhangfu;

import java.util.Date;

public class CsRefund {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.target_id
	 * @mbggenerated
	 */
	private Integer targetId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.target_type
	 * @mbggenerated
	 */
	private Byte targetType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.payee
	 * @mbggenerated
	 */
	private String payee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.payee_phone
	 * @mbggenerated
	 */
	private String payeePhone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.bank_name
	 * @mbggenerated
	 */
	private String bankName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.bank_account
	 * @mbggenerated
	 */
	private String bankAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.return_price
	 * @mbggenerated
	 */
	private Integer returnPrice;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.return_voucher_file_path
	 * @mbggenerated
	 */
	private String returnVoucherFilePath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.status
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.types
	 * @mbggenerated
	 */
	private Byte types;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.process_user_name
	 * @mbggenerated
	 */
	private String processUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.process_user_id
	 * @mbggenerated
	 */
	private Integer processUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.created_at
	 * @mbggenerated
	 */
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.updated_at
	 * @mbggenerated
	 */
	private Date updatedAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cs_refunds.refund_marks_id
	 * @mbggenerated
	 */
	private Integer refundMarksId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.id
	 * @return  the value of cs_refunds.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.id
	 * @param id  the value for cs_refunds.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.target_id
	 * @return  the value of cs_refunds.target_id
	 * @mbggenerated
	 */
	public Integer getTargetId() {
		return targetId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.target_id
	 * @param targetId  the value for cs_refunds.target_id
	 * @mbggenerated
	 */
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.target_type
	 * @return  the value of cs_refunds.target_type
	 * @mbggenerated
	 */
	public Byte getTargetType() {
		return targetType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.target_type
	 * @param targetType  the value for cs_refunds.target_type
	 * @mbggenerated
	 */
	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.payee
	 * @return  the value of cs_refunds.payee
	 * @mbggenerated
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.payee
	 * @param payee  the value for cs_refunds.payee
	 * @mbggenerated
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.payee_phone
	 * @return  the value of cs_refunds.payee_phone
	 * @mbggenerated
	 */
	public String getPayeePhone() {
		return payeePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.payee_phone
	 * @param payeePhone  the value for cs_refunds.payee_phone
	 * @mbggenerated
	 */
	public void setPayeePhone(String payeePhone) {
		this.payeePhone = payeePhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.bank_name
	 * @return  the value of cs_refunds.bank_name
	 * @mbggenerated
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.bank_name
	 * @param bankName  the value for cs_refunds.bank_name
	 * @mbggenerated
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.bank_account
	 * @return  the value of cs_refunds.bank_account
	 * @mbggenerated
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.bank_account
	 * @param bankAccount  the value for cs_refunds.bank_account
	 * @mbggenerated
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.return_price
	 * @return  the value of cs_refunds.return_price
	 * @mbggenerated
	 */
	public Integer getReturnPrice() {
		return returnPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.return_price
	 * @param returnPrice  the value for cs_refunds.return_price
	 * @mbggenerated
	 */
	public void setReturnPrice(Integer returnPrice) {
		this.returnPrice = returnPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.return_voucher_file_path
	 * @return  the value of cs_refunds.return_voucher_file_path
	 * @mbggenerated
	 */
	public String getReturnVoucherFilePath() {
		return returnVoucherFilePath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.return_voucher_file_path
	 * @param returnVoucherFilePath  the value for cs_refunds.return_voucher_file_path
	 * @mbggenerated
	 */
	public void setReturnVoucherFilePath(String returnVoucherFilePath) {
		this.returnVoucherFilePath = returnVoucherFilePath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.status
	 * @return  the value of cs_refunds.status
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.status
	 * @param status  the value for cs_refunds.status
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.types
	 * @return  the value of cs_refunds.types
	 * @mbggenerated
	 */
	public Byte getTypes() {
		return types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.types
	 * @param types  the value for cs_refunds.types
	 * @mbggenerated
	 */
	public void setTypes(Byte types) {
		this.types = types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.process_user_name
	 * @return  the value of cs_refunds.process_user_name
	 * @mbggenerated
	 */
	public String getProcessUserName() {
		return processUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.process_user_name
	 * @param processUserName  the value for cs_refunds.process_user_name
	 * @mbggenerated
	 */
	public void setProcessUserName(String processUserName) {
		this.processUserName = processUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.process_user_id
	 * @return  the value of cs_refunds.process_user_id
	 * @mbggenerated
	 */
	public Integer getProcessUserId() {
		return processUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.process_user_id
	 * @param processUserId  the value for cs_refunds.process_user_id
	 * @mbggenerated
	 */
	public void setProcessUserId(Integer processUserId) {
		this.processUserId = processUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.created_at
	 * @return  the value of cs_refunds.created_at
	 * @mbggenerated
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.created_at
	 * @param createdAt  the value for cs_refunds.created_at
	 * @mbggenerated
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.updated_at
	 * @return  the value of cs_refunds.updated_at
	 * @mbggenerated
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.updated_at
	 * @param updatedAt  the value for cs_refunds.updated_at
	 * @mbggenerated
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cs_refunds.refund_marks_id
	 * @return  the value of cs_refunds.refund_marks_id
	 * @mbggenerated
	 */
	public Integer getRefundMarksId() {
		return refundMarksId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cs_refunds.refund_marks_id
	 * @param refundMarksId  the value for cs_refunds.refund_marks_id
	 * @mbggenerated
	 */
	public void setRefundMarksId(Integer refundMarksId) {
		this.refundMarksId = refundMarksId;
	}
}