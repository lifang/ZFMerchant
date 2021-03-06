package com.comdosoft.financial.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.zhangfu.CsCancel;
import com.comdosoft.financial.user.domain.zhangfu.CsReceiverAddress;
import com.comdosoft.financial.user.domain.zhangfu.CustomerAddress;
import com.comdosoft.financial.user.domain.zhangfu.Merchant;
import com.comdosoft.financial.user.domain.zhangfu.OpeningRequirement;
import com.comdosoft.financial.user.mapper.zhangfu.OpeningApplyMapper;
import com.comdosoft.financial.user.mapper.zhangfu.TerminalsMapper;
import com.comdosoft.financial.user.utils.SysUtils;

@Service
public class TerminalsService {
	@Resource
	private OpeningApplyMapper openingApplyMapper;
	
	@Value("${filePath}")
	private String filePath;
	
	

	@Resource
	private TerminalsMapper terminalsMapper;
	/**
	 * 获得终端列表
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<Object, Object>> getTerminalList(Integer id,
			Integer offSetPage, Integer pageSize,Integer frontStatus,String serialNum) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("id", id);
		map.put("offSetPage", offSetPage);
		map.put("pageSize", pageSize);
		map.put("frontStatus", frontStatus);
		map.put("serialNum", serialNum);
		map.put("hasVideoVerify", OpeningRequirement.TYPE_1);
		List<Map<Object, Object>> list = new ArrayList<Map<Object,Object>>();
		list = terminalsMapper.getTerminalList(map);
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("payChannelId") != null){
				map.put("payChannelId", list.get(i).get("payChannelId"));
				int count = openingApplyMapper.hasVideoVerify(map);
				if(count>0){
					list.get(i).put("hasVideoVerify", 1);
				}
				if(count == 0){
					list.get(i).put("hasVideoVerify", 0);
				}
			}
			
		}
		return list;
	}
	
	public String getOpeningProtocol(int terminalsId){
		return terminalsMapper.getOpeningProtocol(terminalsId);
	}
	
	
	/**
	 * 获得终端列表总记录数
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public int getTerminalListNums(Integer id,
			Integer offSetPage, Integer pageSize,Integer frontStatus,String serialNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("offSetPage", offSetPage);
		map.put("pageSize", pageSize);
		map.put("frontStatus", frontStatus);
		map.put("serialNum", serialNum);
		return terminalsMapper.getTerminalListPage(map);
	}
	
	/**
	 * 添加联系地址
	 * 
	 * @param customerAddress
	 * @return
	 */
	public void addCostometAddress(CustomerAddress customerAddress) {
	    customerAddress.setStatus((byte) CustomerAddress.STATUS_1);
	    customerAddress.setIsDefault(CustomerAddress.ISDEFAULT_2);
		 terminalsMapper.addCostometAddress(customerAddress);
	}
	
	
	/**
     * 判断该终端是否开通
     * 
     * @param map
     * @return
     */
    public int judgeOpen(int terminalId){
    	return terminalsMapper.judgeOpen(terminalId);
    }
	/**
	 * 获得该用户收获地址
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<Object, Object>> getCustomerAddress(Integer id) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("customerId", id);
		map.put("status", CustomerAddress.STATUS_1);
		return terminalsMapper.getCustomerAddress(map);
	}
	
	/**
	 * 换货申请判断
	 * 
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int JudgeChangStatus(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeChangStatus(map);
	}
	
	/**
	 * 跟新申请判断
	 * 
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int judgeUpdateStatus(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeUpdateStatus(map);
	}
	
	/**
	 * 注销申请判断
	 * 
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int JudgeRentalReturnStatus(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeRentalReturnStatus(map);
	}
	
	/**
	 * 维修申请判断
	 * 
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int JudgeRepair(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeRepair(map);
	}
	
	/**
	 * 维修申请判断
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int JudgeReturn(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeReturn(map);
	}
	
	/**
	 * 租赁申请判断
	 * @param terminalId
	 * @param statusa
	 * @param statusb
	 * @return
	 */
	public int JudgeLeaseReturn(Integer terminalId,Integer statusa,Integer statusb) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalId", terminalId);
		map.put("statusa", statusa);
		map.put("statusb", statusb);
		return terminalsMapper.JudgeLeaseReturn(map);
	}
	
	/**
	 * 城市级联
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<Object, Object>> getCities() {
		return terminalsMapper.getCities();
	}
	 /**
     * <!-城市级联(市) -->
     * 
     * @param 
     * @return
     */
	public List<Map<Object, Object>> getShiCities(int parentId) {
		return terminalsMapper.getShiCities(parentId);
	}
	/**
	 * 获得终端状态
	 * @param id
	 * @return
	 */
	public List<Map<Object, Object>> getFrontPayStatus(){
		return terminalsMapper.getTerminStatus();
	}
	
	/**
	 *申请维修添加地址
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public CsReceiverAddress subRepairAddress(Map<Object, Object> map) {
		CsReceiverAddress csReceiverAddress = new CsReceiverAddress();
		csReceiverAddress.setAddress((String)map.get("address"));
		csReceiverAddress.setPhone((String)map.get("phone"));
		csReceiverAddress.setZipCode((String)map.get("zipCode"));
		csReceiverAddress.setReceiver((String)map.get("receiver"));
		terminalsMapper.subRepairAddress(csReceiverAddress);
		return csReceiverAddress;
	}
	
	/**
	 *添加申请维修
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public void subRepair(Map<Object, Object> map) {
		terminalsMapper.subRepair(map);
	}
	
	/**
	 *添加退货
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public void subReturn(Map<Object, Object> map) {
		terminalsMapper.subReturn(map);
	}
	
	/**
	 *添加申请维修
	 * 
	 * @param id
	 * @param offSetPage
	 * @param pageSize
	 * @return
	 */
	public void subChange(Map<Object, Object> map) {
		terminalsMapper.subChange(map);
	}
	
	

	/**
	 * 获得终端详情
	 * @param id
	 * @return
	 */
	public Map<Object, Object> getApplyDetails(Integer id){
		return terminalsMapper.getApplyDetails(id);
	}
	
	/**
	 * 获得租赁信息
	 * @param id
	 * @return
	 */
	public Map<String, String> getTenancy(Integer id){
		return terminalsMapper.getTenancy(id);
	}
	
	
	/**
	 * 获得该终端交易类型详情
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> getRate(Integer id){
		return terminalsMapper.getRate(id);
	}

	/**
	 * 获得追踪记录
	 * @param id
	 * @return
	 */
	public List<Map<String, String>> getTrackRecord(Integer id){
		return terminalsMapper.getTrackRecord(id);
	}
	
	/**
	 * 开通详情
	 * @param id
	 * @return
	 */
	public List<Map<Object, Object>> getOpeningDetails(Integer id){
         
         List<Map<Object, Object>> list = new ArrayList<Map<Object,Object>>();
         list = terminalsMapper.getOpeningDetails(id);
         for(int i=0;i<list.size();i++){
        	 if(list.get(i) !=null){
        		 if((Integer)list.get(i).get("types") == 2){
            		 list.get(i).put("value",filePath+list.get(i).get("value").toString());
            	 }else{
            		 list.get(i).put("value",list.get(i).get("value").toString());
            	 }
        	 }
         }
		return list;
	}
	
	/**
	 * 支付通道列表
	 * @return
	 */
	public List<Map<Object, Object>> getChannels(){
		return terminalsMapper.channels();
	}
	
	/**
	 * 支付通道周期
	 * @return
	 */
	public  List<Map<Object, Object>> channelsT(int id){
		return terminalsMapper.channelsT(id);
	}
	
	
	/**
	 * 判断该终端号是否存在
	 * @param id
	 * @return
	 */
	public int isExistence(String serialNum){
		return terminalsMapper.isExistence(serialNum);
	}
	

	/**
	 * 获得注销模板
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>>  getModule(Integer  terminalsId,int type){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("terminalsId",terminalsId);
		map.put("type", type);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = terminalsMapper.getModule(map);
		for(int i=0;i<list.size();i++){
			list.get(i).put("templet_file_path",filePath+list.get(i).get("templet_file_path").toString());
		}
		return list;
	}
	
	/**
	 * 判断商户名是否存在
	 * @param id
	 * @return
	 */
	public Map<Object, Object> isMerchantName(String title){
		return terminalsMapper.isMerchantName(title);
	}
	
	/**
	 * 添加商户
	 * @param merchant
	 */
	public void addMerchants(Merchant merchant){
		 terminalsMapper.addMerchants(merchant);
	}
	
	/**
	 * 添加终端
	 * @param map
	 */
	public void addTerminal(Map<String, String> map){
		terminalsMapper.addTerminal(map);
	}
	
	/**
	 * 提交注销
	 * @param map
	 */
	public void subRentalReturn(CsCancel csCancel){
		terminalsMapper.subRentalReturn(csCancel);
	}
	

	/**
	 * 提交退还申请
	 * @param map
	 */
	public void subLeaseReturn(Map<Object, Object> map){
		terminalsMapper.subLeaseReturn(map);
	}
	
	/**
	 * 提交更新申请
	 * @param map
	 */
	public void subToUpdate(Map<Object, Object> map){
		terminalsMapper.subToUpdate(map);
	}
	
	
	
	/**
	 * POS找回密码
	 * @param id
	 * @return
	 */
	public String findPassword(Integer id){
		return terminalsMapper.findPassword(id);
	}

	/**
     * author jwb
     * 查询终端开通情况
     * @param paramMap
     * @return
     */
    public List<Map<String,Object>> openStatus(Map<String, Object> paramMap) {
        List<Map<String,Object>> listmap=terminalsMapper.getTerminalListByPhone(paramMap);
        if(null!=listmap&&listmap.size()>0){
            int a=SysUtils.String2int(paramMap.get("type")+"");
            List<Map<String,Object>> listmap2=null;
            int id=0;
            for (Map<String, Object> map : listmap) {
                if(a!=0){
                    map.put("serial_num",SysUtils.toPro(map.get("serial_num").toString()));
                }
                id=SysUtils.String2int(""+map.get("id"));
                listmap2=terminalsMapper.getTerminalOpenStatus(id);
                if(listmap2!=null&&listmap2.size()>0){
                    map.put("openStatus", listmap2);
                }else{
                    map.put("openStatus", listmap2);
                    map.put("error", "未申请");
                }
                
            }
        }
        return listmap;
    }
    
    public Map<Object,Object> getTerminalById(Integer terminalId){
		return  terminalsMapper.getTerminalById(terminalId);
	}
    
}
