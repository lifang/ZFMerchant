package com.comdosoft.financial.manage.domain.trades;

import java.util.Date;

public class TradeTransferRepaymentRecord {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.pay_into_account
	 * @mbggenerated
	 */
	private String payIntoAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.pay_from_account
	 * @mbggenerated
	 */
	private String payFromAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.types
	 * @mbggenerated
	 */
	private Byte types;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.arrived_result
	 * @mbggenerated
	 */
	private Integer arrivedResult;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.arrived_code
	 * @mbggenerated
	 */
	private Integer arrivedCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.arrived_error_description
	 * @mbggenerated
	 */
	private String arrivedErrorDescription;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.returned_result
	 * @mbggenerated
	 */
	private Integer returnedResult;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.returned_code
	 * @mbggenerated
	 */
	private Integer returnedCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.returned_error_description
	 * @mbggenerated
	 */
	private String returnedErrorDescription;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.created_at
	 * @mbggenerated
	 */
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column trade_transfer_repayment_records.updated_at
	 * @mbggenerated
	 */
	private Date updatedAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.id
	 * @return  the value of trade_transfer_repayment_records.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.id
	 * @param id  the value for trade_transfer_repayment_records.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.pay_into_account
	 * @return  the value of trade_transfer_repayment_records.pay_into_account
	 * @mbggenerated
	 */
	public String getPayIntoAccount() {
		return payIntoAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.pay_into_account
	 * @param payIntoAccount  the value for trade_transfer_repayment_records.pay_into_account
	 * @mbggenerated
	 */
	public void setPayIntoAccount(String payIntoAccount) {
		this.payIntoAccount = payIntoAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.pay_from_account
	 * @return  the value of trade_transfer_repayment_records.pay_from_account
	 * @mbggenerated
	 */
	public String getPayFromAccount() {
		return payFromAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.pay_from_account
	 * @param payFromAccount  the value for trade_transfer_repayment_records.pay_from_account
	 * @mbggenerated
	 */
	public void setPayFromAccount(String payFromAccount) {
		this.payFromAccount = payFromAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.types
	 * @return  the value of trade_transfer_repayment_records.types
	 * @mbggenerated
	 */
	public Byte getTypes() {
		return types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.types
	 * @param types  the value for trade_transfer_repayment_records.types
	 * @mbggenerated
	 */
	public void setTypes(Byte types) {
		this.types = types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.arrived_result
	 * @return  the value of trade_transfer_repayment_records.arrived_result
	 * @mbggenerated
	 */
	public Integer getArrivedResult() {
		return arrivedResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.arrived_result
	 * @param arrivedResult  the value for trade_transfer_repayment_records.arrived_result
	 * @mbggenerated
	 */
	public void setArrivedResult(Integer arrivedResult) {
		this.arrivedResult = arrivedResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.arrived_code
	 * @return  the value of trade_transfer_repayment_records.arrived_code
	 * @mbggenerated
	 */
	public Integer getArrivedCode() {
		return arrivedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.arrived_code
	 * @param arrivedCode  the value for trade_transfer_repayment_records.arrived_code
	 * @mbggenerated
	 */
	public void setArrivedCode(Integer arrivedCode) {
		this.arrivedCode = arrivedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.arrived_error_description
	 * @return  the value of trade_transfer_repayment_records.arrived_error_description
	 * @mbggenerated
	 */
	public String getArrivedErrorDescription() {
		return arrivedErrorDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.arrived_error_description
	 * @param arrivedErrorDescription  the value for trade_transfer_repayment_records.arrived_error_description
	 * @mbggenerated
	 */
	public void setArrivedErrorDescription(String arrivedErrorDescription) {
		this.arrivedErrorDescription = arrivedErrorDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.returned_result
	 * @return  the value of trade_transfer_repayment_records.returned_result
	 * @mbggenerated
	 */
	public Integer getReturnedResult() {
		return returnedResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.returned_result
	 * @param returnedResult  the value for trade_transfer_repayment_records.returned_result
	 * @mbggenerated
	 */
	public void setReturnedResult(Integer returnedResult) {
		this.returnedResult = returnedResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.returned_code
	 * @return  the value of trade_transfer_repayment_records.returned_code
	 * @mbggenerated
	 */
	public Integer getReturnedCode() {
		return returnedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.returned_code
	 * @param returnedCode  the value for trade_transfer_repayment_records.returned_code
	 * @mbggenerated
	 */
	public void setReturnedCode(Integer returnedCode) {
		this.returnedCode = returnedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.returned_error_description
	 * @return  the value of trade_transfer_repayment_records.returned_error_description
	 * @mbggenerated
	 */
	public String getReturnedErrorDescription() {
		return returnedErrorDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.returned_error_description
	 * @param returnedErrorDescription  the value for trade_transfer_repayment_records.returned_error_description
	 * @mbggenerated
	 */
	public void setReturnedErrorDescription(String returnedErrorDescription) {
		this.returnedErrorDescription = returnedErrorDescription;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.created_at
	 * @return  the value of trade_transfer_repayment_records.created_at
	 * @mbggenerated
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.created_at
	 * @param createdAt  the value for trade_transfer_repayment_records.created_at
	 * @mbggenerated
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column trade_transfer_repayment_records.updated_at
	 * @return  the value of trade_transfer_repayment_records.updated_at
	 * @mbggenerated
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column trade_transfer_repayment_records.updated_at
	 * @param updatedAt  the value for trade_transfer_repayment_records.updated_at
	 * @mbggenerated
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}