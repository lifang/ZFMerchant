package com.comdosoft.financial.user.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.zhangfu.MyOrderReq;
import com.comdosoft.financial.user.domain.zhangfu.RepairStatus;
import com.comdosoft.financial.user.domain.zhangfu.UpdateStatus;
import com.comdosoft.financial.user.mapper.zhangfu.CsLeaseReturnsMapper;
import com.comdosoft.financial.user.utils.OrderUtils;
import com.comdosoft.financial.user.utils.page.Page;
import com.comdosoft.financial.user.utils.page.PageRequest;

@Service
public class CsLeaseReturnsService {

    private static final Logger logger = LoggerFactory.getLogger(CsLeaseReturnsService.class);
    @Resource
    private CsLeaseReturnsMapper csLeaseReturnsMapper;
    @Resource
    private CsCencelsService csCencelsService;
    
    public Page<List<Object>> findAll(MyOrderReq myOrderReq) throws ParseException {
        PageRequest request = new PageRequest(myOrderReq.getPage(), myOrderReq.getRows());
        List<Map<String, Object>> o = csLeaseReturnsMapper.findAll(myOrderReq);
        int count = csLeaseReturnsMapper.count(myOrderReq);
        List<Map<String, Object>> list = putDate(o);
        return new Page<List<Object>>(request, list,count);
    }

    public void cancelApply(MyOrderReq myOrderReq) {
        myOrderReq.setRepairStatus(RepairStatus.CANCEL);
        csLeaseReturnsMapper.cancelApply(myOrderReq);
    }

    //   returnprice 没有 就显示  计算的价格    ，  计算价格大于0 就写（参考金额）
    public Map<String, Object> findById(MyOrderReq myOrderReq)  {
        Map<String, Object> o = csLeaseReturnsMapper.findById(myOrderReq);
        Map<String, Object> map = new HashMap<String, Object>();
        String id = o.get("id").toString();
        map.put("id", id);
        map.put("status", o.get("apply_status"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");
        String apply_time =   o.get("apply_time")==null?"":o.get("apply_time").toString();
        if(apply_time==""){
            map.put("apply_time", "");
        }else{
            try {
				map.put("apply_time", sdf.format(sdf.parse(apply_time)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        String one_time = o.get("one_time")==null?"":o.get("one_time").toString(); // cs_lease_retruns. created_at
        String two_time = o.get("two_time")==null?"":o.get("two_time").toString(); // order updated_at
        if(one_time!="" && two_time!=""){
            String one_d="";
        	String two_d ="";
			try {
				one_d = _sdf.format(_sdf.parse(one_time));
				 two_d = _sdf.format(_sdf.parse(two_time));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        logger.debug("one_d==="+one_d+"===>>>two_d=="+two_d);
            Double day = (double) OrderUtils.compareDate(two_d,one_d );// 租赁时长
           logger.debug("租赁时长为： "+day+"天");
            map.put("lease_time", two_d);//租赁日期
            if(day<0){
                day = 0d;
            }
            int min = (int) o.get("lease_time");// 最少租赁时间，月为单位
            int max = (int) o.get("return_time");// 租赁归还时间，月为单位
            double f = day / 30;
            int month = 1;
            if (f > 1) {
                month = (int) Math.ceil(f);
            }
            if(month < min){
            	month = min;
            }
           logger.debug(">>>租赁时长 "+day+"天>>最短时间为》》"+min+ "租赁了"+month+"个月");
            int zj = (int) o.get("lease_price");// 每个月的租金
            Integer total_zj = zj * month;
            map.put("lease_price", total_zj);// 总共租金
            
            Integer lease_deposit = (Integer) (o.get("lease_deposit") ==null?0:o.get("lease_deposit"));
            map.put("lease_deposit", lease_deposit); // 租赁押金
            BigDecimal return_price = new BigDecimal(lease_deposit).subtract(new BigDecimal(total_zj));
            logger.debug("return_price==>>"+return_price+"  >>>>  租金 》》》"+total_zj);
            if(return_price.doubleValue()<0){
                return_price = new BigDecimal(0);
            }
            map.put("return_price", return_price ); // 退还金额
           Integer  crf_retrun_price =   (Integer) (o.get("crf_retrun_price")==null?0: o.get("crf_retrun_price"));
            map.put("crf_retrun_price", crf_retrun_price ); // 退还金额
           
//            if(day<min*30){
//            	map.put("lease_length", min*30 ); // 租赁时长 天
//            }else{
            	map.put("lease_length", day.intValue() ); // 租赁时长 天
//            }
            map.put("lease_min_time", min ); // 最短时间 天
            map.put("lease_max_time", max); // 最长时间 天
//             logger.debug("租赁id为"+id+"的租赁押金："+o.get("lease_deposit")+" 租金："+zj*month+
//                     "  租赁时长:"+day+"天"+"  最长租赁时间："+max * 30+"天"+" 最短租赁时间:"+min*30+"天");
            myOrderReq.setId(Integer.parseInt(id));
        }else{
            logger.error("时间日期出错了。。。。"); 
        }
        map.put("terminal_num", o.get("serial_num")==null?"":o.get("serial_num"));
        /**
    	 * 退款状态1.待处理
    	 * 退款状态2.处理完成
    	 * 退款状态3.已取消
    	 */
        map.put("crf_status", o.get("crf_status")==null?"0":o.get("crf_status"));
        map.put("apply_num", o.get("apply_num")==null?"":o.get("apply_num"));
        map.put("brand_name", o.get("brand_name")==null?"":o.get("brand_name"));
        map.put("brand_number", o.get("brand_number")==null?"":o.get("brand_number"));
        map.put("zhifu_pingtai", o.get("zhifu_pt")==null?"":o.get("zhifu_pt"));
        map.put("merchant_name", o.get("merchant_name") ==null ?"":o.get("merchant_name"));
        map.put("merchant_phone", o.get("mer_phone")==null?"":o.get("mer_phone"));
        map.put("receiver_name", o.get("receiver")==null?"":o.get("receiver"));
        map.put("receiver_phone", o.get("receiver_phone") ==null?"":o.get("receiver_phone"));
        map.put("receiver_addr", o.get("address") ==null?"":o.get("address"));
        List<Map<String, Object>> list = csLeaseReturnsMapper.findTraceById(myOrderReq);
        String json = o.get("templete_info_xml")==null?"":o.get("templete_info_xml").toString();
        if( json=="" ){
        	map.put("resource_info", new ArrayList<>());
        }else{
        	map = csCencelsService.getTemplePaths(map, json);
        }
        map.put("comments", OrderUtils.getTraceByVoId(myOrderReq, list));
        return map;
    }

    public void addMark(MyOrderReq myOrderReq) {
        csLeaseReturnsMapper.addMark(myOrderReq);
    }

    public void resubmitCancel(MyOrderReq myOrderReq) {
        myOrderReq.setUpdateStatus(UpdateStatus.PENDING);
        csLeaseReturnsMapper.changeStatus(myOrderReq);
    }

    public Page<List<Object>> search(MyOrderReq myOrderReq) throws ParseException {
        PageRequest request = new PageRequest(myOrderReq.getPage(), myOrderReq.getRows());
        List<Map<String, Object>> o = csLeaseReturnsMapper.search(myOrderReq);
        int count = csLeaseReturnsMapper.countSearch(myOrderReq);
        List<Map<String, Object>> list = putDate(o);
        return new Page<List<Object>>(request, list,count);
    }

    public List<Map<String, Object>> putDate(List<Map<String, Object>> o) throws ParseException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map<String, Object> m : o) {
            map = new HashMap<String, Object>();
            String d = (m.get("created_at") + "");
            Date date = sdf.parse(d);
            String c_date = sdf.format(date);
            map.put("id", m.get("id"));
            map.put("status", m.get("status")==null?"":m.get("status"));
            map.put("create_time", c_date);
            map.put("terminal_num", m.get("serial_num")==null?"":m.get("serial_num"));// 终端号
            map.put("apply_num", m.get("apply_num")==null?"":m.get("apply_num"));// 维修编号
            map.put("brand_name", m.get("brand_name")==null?"":m.get("brand_name"));
            map.put("brand_number", m.get("brand_number")==null?"":m.get("brand_number"));
            map.put("zhifu_pingtai", m.get("zhifu_pt")==null?"":m.get("zhifu_pt"));
            map.put("merchant_name", m.get("merchant_name")==null?"":m.get("merchant_name"));
            map.put("merchant_phone", m.get("mer_phone")==null?"":m.get("mer_phone"));
            list.add(map);
        }
        return list;
    }

}
