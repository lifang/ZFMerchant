package com.comdosoft.financial.user.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.zhangfu.Merchant;
import com.comdosoft.financial.user.domain.zhangfu.OpeningApplie;
import com.comdosoft.financial.user.domain.zhangfu.OpeningRequirement;
import com.comdosoft.financial.user.domain.zhangfu.Terminal;
import com.comdosoft.financial.user.mapper.zhangfu.OpeningApplyMapper;

@Service
public class OpeningApplyService {
	@Resource
	private OpeningApplyMapper openingApplyMapper;

	/**
	 * 获得申请开通列表
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<Object, Object>> getApplyList(Integer id,
			Integer offSetPage, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("offSetPage", offSetPage);
		map.put("pageSize", pageSize);
		map.put("twoStatus", Terminal.TerminalTYPEID_2);
		map.put("threeStatus", Terminal.TerminalTYPEID_3);
		return openingApplyMapper.getApplyList(map);
	}

	/**
	 * 获得终端详情
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getApplyDetails(Integer id) {
		return openingApplyMapper.getApplyDetails(id);
	}
	
	/**
	 * 获得申请开通已有基本信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getOppinfo(Integer terminalsId,Integer status) {
		OpeningApplie openingApplie =new OpeningApplie();
		openingApplie.setTerminalId(terminalsId);
		openingApplie.setTypes(status);
		return openingApplyMapper.getOppinfo(openingApplie);
	}
	
	
	/**
	 * 获得终端材料等级个数
	 * 
	 * @param id
	 * @return
	 */
	public List<OpeningRequirement> getMaterialLevel( int terminalsId) {
		return openingApplyMapper.getMaterialLevel(terminalsId);
	}

	/**
	 * 获得所有商户列表
	 * 
	 * @return
	 */
	public List<Merchant> getMerchants(int customerId) {
		return openingApplyMapper.getMerchants(customerId);
	}
	
	/**
	 * 申请开通时判断商户是否存在
	 * 
	 * @return
	 */
	public int getMerchantsIsNo(String legalPersonCardId) {
		return openingApplyMapper.getMerchantsIsNo(legalPersonCardId);
	}
	
	/**
	 * 申请开通时判断商户是否存在
	 * 
	 * @return
	 */
	public void addMerchan(Merchant merchant) {
		openingApplyMapper.addMerchan(merchant);
	}
	
	/**
	 * 获得所有通道
	 * @return
	 */
	public List<Map<Object, Object>> getChannels(){
		return openingApplyMapper.getChannels();
	}
	
	/**
	 * 获得所有通道周期
	 * @return
	 */
	public List<Map<Object, Object>> channelsT(int id){
		return openingApplyMapper.channelsT(id);
	}
	
	/**
	 * 申请资料数据回显
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> ReApplyFor(Integer id) {
		
		 SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
		 List<Map<String, String>> list = openingApplyMapper.ReApplyFor(id);
			for(Map<String, String> map:list){
				map.put("birthday", sdf.format(map.get("birthday")));
				map.put("created_at", sdf.format(map.get("created_at")));
				map.put("updated_at", sdf.format(map.get("updated_at")));
			}
		return list;
	}

	/**
	 * 根据商户id获得详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, String> getMerchant(Integer merchantId) {
		return openingApplyMapper.getMerchant(merchantId);
	}

	/**
	 * 添加开通申请资料
	 * 
	 * @param map
	 */
	public void addApply(String key, Object value,Integer types, String openingAppliesId,Integer openingRequirementId,Integer targetId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", key);
		map.put("value", value);
		map.put("types", types);
		map.put("openingAppliesId", openingAppliesId);
		map.put("openingRequirementId", openingRequirementId);
		map.put("targetId", targetId);
		openingApplyMapper.addApply(map);
	}

	/**
	 * 添加 开通申请关联
	 */
	public void addOpeningApply(OpeningApplie openingApplie) {
		openingApplyMapper.addOpeningApply(openingApplie);

	}
	
	/**
	 * 修改开通申请资料
	 */
	public void updateApply(OpeningApplie openingApplie) {
		openingApplyMapper.updateApply(openingApplie);

	}
	
	

	/**
	 * 获得材料名字
	 * 
	 * @param id
	 * @return
	 */
	public List<Merchant> getMaterialName(Integer id, Integer status) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("terminalsId", id);
		map.put("status", status);
		return openingApplyMapper.getMaterialName(map);
	}
	
	/**
	 * 获得材料名字
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<Object, Object>> getMaterialNameMap(Integer id, Integer status) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("terminalsId", id);
		map.put("status", status);
		return openingApplyMapper.getMaterialNameMap(map);
	}
	
	/**
	 * 获得申请表的id
	 * 
	 * @param id
	 * @return
	 */
	public int getApplyesId(Integer id) {
		return openingApplyMapper.getApplyesId(id);
	}

	/**
	 * 重新申请开通(先删除旧数据)
	 * 
	 * @param id
	 */
	public void deleteOpeningInfos(Integer id) {
		openingApplyMapper.deleteOpeningInfos(id);
	}
}
