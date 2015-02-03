package com.comdosoft.financial.manage.mapper.zhangfu;

import com.comdosoft.financial.manage.domain.zhangfu.Agent;
import java.util.List;

public interface AgentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table agents
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table agents
	 * @mbggenerated
	 */
	int insert(Agent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table agents
	 * @mbggenerated
	 */
	Agent selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table agents
	 * @mbggenerated
	 */
	List<Agent> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table agents
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Agent record);
}