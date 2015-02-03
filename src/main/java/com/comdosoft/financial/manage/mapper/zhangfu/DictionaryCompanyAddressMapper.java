package com.comdosoft.financial.manage.mapper.zhangfu;

import com.comdosoft.financial.manage.domain.zhangfu.DictionaryCompanyAddress;
import java.util.List;

public interface DictionaryCompanyAddressMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dictionary_company_addresses
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dictionary_company_addresses
	 * @mbggenerated
	 */
	int insert(DictionaryCompanyAddress record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dictionary_company_addresses
	 * @mbggenerated
	 */
	DictionaryCompanyAddress selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dictionary_company_addresses
	 * @mbggenerated
	 */
	List<DictionaryCompanyAddress> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dictionary_company_addresses
	 * @mbggenerated
	 */
	int updateByPrimaryKey(DictionaryCompanyAddress record);
}