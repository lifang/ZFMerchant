package com.comdosoft.financial.manage.mapper.zhangfu;

import com.comdosoft.financial.manage.domain.zhangfu.GoodsPayChannel;
import java.util.List;

public interface GoodsPayChannelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_pay_channels
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_pay_channels
	 * @mbggenerated
	 */
	int insert(GoodsPayChannel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_pay_channels
	 * @mbggenerated
	 */
	GoodsPayChannel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_pay_channels
	 * @mbggenerated
	 */
	List<GoodsPayChannel> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods_pay_channels
	 * @mbggenerated
	 */
	int updateByPrimaryKey(GoodsPayChannel record);
}