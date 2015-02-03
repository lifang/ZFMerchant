package com.comdosoft.financial.manage.mapper.zhangfu;

import com.comdosoft.financial.manage.domain.zhangfu.WebMessage;
import java.util.List;

public interface WebMessageMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_messages
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_messages
	 * @mbggenerated
	 */
	int insert(WebMessage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_messages
	 * @mbggenerated
	 */
	WebMessage selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_messages
	 * @mbggenerated
	 */
	List<WebMessage> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_messages
	 * @mbggenerated
	 */
	int updateByPrimaryKey(WebMessage record);
}