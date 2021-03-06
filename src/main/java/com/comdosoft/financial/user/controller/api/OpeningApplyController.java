package com.comdosoft.financial.user.controller.api;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comdosoft.financial.user.domain.Response;
import com.comdosoft.financial.user.domain.zhangfu.Merchant;
import com.comdosoft.financial.user.domain.zhangfu.OpeningApplie;
import com.comdosoft.financial.user.service.OpeningApplyService;
import com.comdosoft.financial.user.service.TerminalsService;
import com.comdosoft.financial.user.utils.page.PageRequest;

/**
 * 
 * 开通申请<br>
 * <功能描述>
 *
 * @author xfh 2015年2月5日
 *
 */
@RestController
@RequestMapping(value = "/api/apply")
public class OpeningApplyController {

	@Resource
	private OpeningApplyService openingApplyService;
	
	@Resource
	private TerminalsService terminalsService;
	
	@Value("${filePath}")
	private String filePath;
	
	/**
	 * 根据用户ID获得开通申请列表
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getApplyList", method = RequestMethod.POST)
	public Response getApplyList(@RequestBody Map<String, Object> map) {
		try {
			PageRequest PageRequest = new PageRequest((Integer)(map.get("page")),
					(Integer)map.get("rows"));

			int offSetPage = PageRequest.getOffset();
			return Response.getSuccess(openingApplyService.getApplyList(
					((Integer)map.get("customersId")),
					offSetPage, 
					((Integer)map.get("rows"))));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getError("获取列表失败！");
		}
	}
	
	/**
	 * 进入申请开通
	 * 
	 * @param id
	 */
	@RequestMapping(value = "getApplyDetails", method = RequestMethod.POST)
	public Response getApplyDetails(@RequestBody Map<String, Object> maps) {
		try {
			Map<Object, Object> map = new HashMap<Object, Object>();
			// 获得终端详情
			Map<String, Object> objmap = new HashMap<String, Object>();
			objmap = openingApplyService.getApplyDetails((Integer)maps.get("terminalsId"));
			map.put("applyDetails",objmap);
			// 获得所有商户
			map.put("merchants", openingApplyService.getMerchants((Integer)maps.get("customerId")));
			// 数据回显(重新开通申请)
			map.put("applyFor", openingApplyService.ReApplyFor((Integer)maps.get("terminalsId")));
			// 材料名称
			if(objmap.get("supportRequirementType")!= null){
				if(Integer.parseInt(objmap.get("supportRequirementType").toString())<3){
					map.put("materialName",
							openingApplyService.getMaterialName((Integer)maps.get("terminalsId"),
									Integer.parseInt(objmap.get("supportRequirementType").toString())));
				}else {
					map.put("materialName",
							openingApplyService.getMaterialName((Integer)maps.get("terminalsId"),
								(Integer)maps.get("status")));
				}
			}
			
			// 获得已有申请开通基本信息
			map.put("openingInfos",
					openingApplyService.getOppinfo((Integer)maps.get("terminalsId")));
			return Response.getSuccess(map);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getError("请求失败！");
		}
	}
	
	/**
	 * 根据商户id获得商户详细信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getMerchant", method = RequestMethod.POST)
	public Response getMerchant(@RequestBody Map<String, Object> map) {
		try {
			Map<String, String> merchant = new HashMap<String, String>();
			merchant = openingApplyService.getMerchant((Integer)map.get("merchantId"));
			return Response.getSuccess(merchant);
		} catch (Exception e) {
			return Response.getError("请求失败！");
		}

	}
	
	/**
	 * 获得所有通道
	 */
	@RequestMapping(value = "getChannels", method = RequestMethod.POST)
	public Response getChannels() {
		try {
			//支付通道和周期列表
			List<Map<Object, Object>> list = openingApplyService.getChannels();
			 for(Map<Object, Object> m:list){
				 List<Map<Object, Object>> listT = openingApplyService.channelsT(Integer.parseInt(m.get("id").toString()));
				 if(listT == null){
					 m.put("billings","");
				 }else if(listT != null){
					 m.put("billings",listT);
				 }
			 }
			 return Response.getSuccess(list);
		} catch (Exception e) {
			return Response.getError("请求失败！");
		}
	}
	
	/**
	 * 从第三方接口获得银行
	 */
	/*@RequestMapping(value = "ChooseBank", method = RequestMethod.POST)
	public Response ChooseBank(@RequestBody Map<String, Object> map) {
		try {
			List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			Map<String, String> map1 = new HashMap<String, String>();
			map1.put("name", "中国农业银行");
			map1.put("code", "111111");
			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("name", "中国工商银行");
			map2.put("code", "222222");
			list.add(map1);
			list.add(map2);
			return Response.getSuccess(list);
		} catch (Exception e) {
			return Response.getError("请求失败！");
		}
	}*/
	
	/**
	 * 对公对私材料名称(1 对公， 2对私)
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "getMaterialName", method = RequestMethod.POST)
	public Response getMaterialName(@RequestBody Map<String, Object> map) {
		try {
			return Response.getSuccess(openingApplyService.getMaterialName(
					(Integer)map.get("terminalId")
					, (Integer)map.get("status")));
		} catch (Exception e) {
			return Response.getError("请求失败！");
		}
	}
	
	/**
	 * 添加申请信息
	 * 
	 * @param paramMap
	 */
	@RequestMapping(value = "addOpeningApply", method = RequestMethod.POST)
	//public Response addOpeningApply(@RequestBody List<Map<String, Object>> paramMap) {
		public Response addOpeningApply(@RequestBody Map<Object, Object> applyMap) {
		try {
			OpeningApplie openingApplie = new OpeningApplie();
			String openingAppliesId = null;
			Integer terminalId = null;
			String key = null;
			Object value = null;
			Integer types = null;
			Integer openingRequirementId = null;
			Integer targetId =null;
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) applyMap.get("paramMap");
			
			int y = 0;
			for (Map<String, Object> map : list) {
				if (y == 0) {
					terminalId = (Integer)map.get("terminalId");
					//获得申请基本资料
					openingApplie.setTerminalId((Integer) map
							.get("terminalId"));
					openingApplie.setApplyCustomerId((Integer) map
							.get("applyCustomerId"));
					openingApplie.setTypes((Integer) map
							.get("publicPrivateStatus"));
					openingApplie.setMerchantId((Integer) map
							.get("merchantId"));
					openingApplie.setMerchantName((String) map
							.get("merchantName"));
					openingApplie.setSex((Integer) map
							.get("sex"));
					openingApplie.setBirthday( new SimpleDateFormat("yyyy-MM-dd").parse((String) map.get("birthday")));
					openingApplie.setCardId((String) map
							.get("cardId"));
					openingApplie.setPhone((String) map
							.get("phone"));
					openingApplie.setEmail((String) map
							.get("email"));
					openingApplie.setCityId((Integer) map
							.get("cityId"));
					openingApplie.setName((String) map
							.get("name"));
					openingApplie.setPayChannelId((Integer) map
							.get("channel"));
					openingApplie.setBillingCydeId((Integer) map
							.get("billingId"));
					openingApplie.setAccountBankNum((String) map
							.get("bankNum"));
					openingApplie.setAccountBankName((String) map
							.get("bankName"));
					openingApplie.setAccountBankCode((String) map
							.get("bankCode"));
					openingApplie.setTaxRegisteredNo((String) map
							.get("registeredNo"));
					openingApplie.setOrganizationCodeNo((String) map
							.get("organizationNo"));
					openingApplie.setBankName((String) map
							.get("bank_name"));
					Map<String, Object> m = openingApplyService.getApplyDetails(terminalId);
					if(!(Boolean)m.get("needPreliminaryVerify")){
						openingApplie.setStatus(OpeningApplie.STATUS_5);
					}
					if((Boolean)m.get("needPreliminaryVerify")){
						openingApplie.setStatus(OpeningApplie.STATUS_1);
					}
					//判断该商户是否存在
					Map<Object, Object> countMap =  openingApplyService.getMerchantsIsNo((String) map.get("merchantName"),(String) map.get("phone"));
					if(countMap == null){
						//添加商户
						Merchant merchant = new Merchant();
						merchant.setLegalPersonName((String) map
								.get("name"));
						merchant.setLegalPersonCardId((String) map
								.get("cardId"));
						merchant.setTitle((String) map
								.get("merchantName"));
						merchant.setTaxRegisteredNo((String) map
								.get("registeredNo"));
						merchant.setOrganizationCodeNo((String) map
								.get("organizationNo"));
						merchant.setAccountBankNum((String) map
								.get("bankNum"));
						merchant.setCustomerId((Integer) map
								.get("applyCustomerId"));
						merchant.setPhone((String) map
								.get("phone"));
						merchant.setCityId((Integer)map.get("cityId"));
						openingApplyService.addMerchan(merchant);
						//获得添加后商户Id
						//terminalId = merchant.getId();
						openingApplie.setMerchantId(merchant.getId());
					}else if(countMap !=null){
						openingApplie.setMerchantId((Integer)countMap.get("id"));
					}
					//为终端表关联对应的商户id和通道周期ID 
					openingApplyService.updateterminal(openingApplie.getMerchantId(),terminalId,(Integer) map
							.get("billingId"));
					//判断该申请是否为从新申请
					if(terminalsService.judgeOpen(terminalId) != 0){
						openingAppliesId = String.valueOf(openingApplyService
								.getApplyesId(terminalId));
						// 删除旧数据
						openingApplyService.deleteOpeningInfos(Integer
								.valueOf(openingAppliesId));
						//修改申请表中的基本资料
						openingApplie.setId(Integer.parseInt(openingAppliesId));
						openingApplyService.updateApply(openingApplie);
					} else {
						openingApplyService.addOpeningApply(openingApplie);
						openingAppliesId = String
								.valueOf(openingApplie.getId());
					}
				} else {
						key = (String) map.get("key");
						types = (Integer) map.get("types");
						if(types == 2){
							value =  map.get("value").toString().substring(filePath.length());
						}else{
							value = map.get("value");
						}
						openingRequirementId = (Integer) map.get("openingRequirementId");
						targetId =(Integer) map.get("targetId");
					openingApplyService.addApply(key, value,types, openingAppliesId,openingRequirementId,targetId);
				}
				y++;
			}
			return Response.getSuccess("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getError("请求失败！");
		}
	}
	
	/**
	 * 视频认证
	 */
	@RequestMapping(value = "videoAuthentication", method = RequestMethod.POST)
	public Response videoAuthentication() {
		try {
			return Response.getSuccess("视频认证");
		} catch (Exception e) {
			return Response.getError("视频认证异常");
		}
	}
}
