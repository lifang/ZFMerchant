package com.comdosoft.financial.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.query.PosReq;
import com.comdosoft.financial.user.mapper.zhangfu.CommentMapper;
import com.comdosoft.financial.user.mapper.zhangfu.GoodMapper;
import com.comdosoft.financial.user.utils.SysUtils;

@Service
public class GoodService {

    @Autowired
    private GoodMapper goodMapper;
    
    @Autowired
    private CommentMapper cMapper;
    
    @Autowired
    private PayChannelService pcService;
    
    @Value("${filePath}")
    private String filePath;

    public Map<String,Object> getGoodsList(PosReq posreq) {
        Map<String,Object> result=new HashMap<String, Object>();
        if(posreq.getCity_id()!=0){
            posreq.setSheng_id(goodMapper.getShengId(posreq.getCity_id()));
        }
        List<Map<String, Object>> list = goodMapper.getGoodsList(posreq);
        int total=goodMapper.getGoodsTotal(posreq);
        for (Map<String, Object> map : list) {
            int id = SysUtils.String2int("" + map.get("id"));
            // 支付通道
            posreq.setGoodId(id);
            List<Map<String, Object>> payChannelList = goodMapper.getPayChannelListByGoodId(posreq);
            int openprice=0;
            if (null != payChannelList && payChannelList.size() > 0) {
                map.put("pay_channe", payChannelList.get(0).get("name"));
                openprice=SysUtils.String2int(payChannelList.get(0).get("opening_cost").toString()); 
            }
            map.put("retail_price", SysUtils.String2int(map.get("retail_price").toString())+openprice);
            // 图片
            List<String> goodPics = goodMapper.getgoodPics(id);
            //List<String> goodPics = goodMapper.getgoodPics_s(id);
            if (null != goodPics && goodPics.size() > 0) {
                map.put("url_path",filePath+ goodPics.get(0));
            }
        }
        result.put("list", list);
        result.put("total",total);
        return result;
    }

    public Map<String, Object> getGoods(PosReq posreq) {
        if(posreq.getCity_id()!=0){
            posreq.setSheng_id(goodMapper.getShengId(posreq.getCity_id()));
        }
        Map<String, Object> goodInfoMap = null;
        // 商品信息
        Map<String, Object> goodinfo = goodMapper.getGoodById(posreq.getGoodId());
        int id = SysUtils.String2int("" + goodinfo.get("id"));
        if (id > 0) {
            goodInfoMap = new HashMap<String, Object>();
            goodInfoMap.put("goodinfo", goodinfo);
            // 支付通道
            List<Map<String, Object>> payChannelList = goodMapper.getPayChannelListByGoodId(posreq);
            if (null != payChannelList && payChannelList.size() > 0) {
                goodInfoMap.put("payChannelList", payChannelList);
                int pcid=SysUtils.String2int("" +payChannelList.get(0).get("id"));
                goodInfoMap.put("paychannelinfo",pcService.payChannelInfo(pcid));
            }
            // 图片
            List<String> goodPics = goodMapper.getgoodPics(posreq.getGoodId());
            if(goodPics!=null&&goodPics.size()>0){
                for (int i = 0; i < goodPics.size(); i++) {
                    goodPics.set(i, filePath+ goodPics.get(i));
                }
            }
            goodInfoMap.put("goodPics", goodPics);
            // 评论数
            int commentsCount = cMapper.getCommentCount(posreq.getGoodId());
            goodInfoMap.put("commentsCount", commentsCount);
            // 生产厂家
            int factoryId = SysUtils.String2int("" + goodinfo.get("factory_id"));
            if (factoryId > 0) {
                Map<String, Object> factoryMap = goodMapper.getFactoryById(factoryId);
                if(factoryMap!=null){
                    factoryMap.put("logo_file_path", filePath+factoryMap.get("logo_file_path"));
                    goodInfoMap.put("factory", factoryMap);
                }
            }
            List<Map<String, Object>> relativeShopList = goodMapper.getRelativeShopListByGoodId(posreq);
            if (null != relativeShopList && relativeShopList.size() > 0) {
               for (Map<String, Object> map : relativeShopList) {
                   // 图片
                   List<String> goodPics2 = goodMapper.getgoodPics( SysUtils.String2int(map.get("id").toString()));
                   if (null != goodPics2 && goodPics2.size() > 0) {
                       map.put("url_path", filePath+goodPics2.get(0));
                   }
                   int openprice=0;
                   int googid=SysUtils.String2int(map.get("id").toString());
                   posreq.setGoodId(googid);
                   List<Map<String, Object>> pclist = goodMapper.getPayChannelListByGoodId(posreq);
                   if (null != pclist && pclist.size() > 0) {
                       openprice=SysUtils.String2int(pclist.get(0).get("opening_cost").toString()); 
                   }
                   map.put("retail_price", SysUtils.String2int(map.get("retail_price").toString())+openprice);
               }
            }
            goodInfoMap.put("relativeShopList",relativeShopList);
            
            List<Map<String, Object>> picList=goodMapper.getPicList(id);
            if(picList!=null){
	            for(int i=0;i<picList.size();i++){
	            	if(picList.get(i).get("urlPath")!=null){
		            	String urlPath=filePath+picList.get(i).get("urlPath").toString();
		            	picList.get(i).put("urlPath", urlPath);
            		}
	            }
            }
            goodInfoMap.put("picList", picList);
            
        }
        return goodInfoMap;
    }

    public Map<String, Object> getSearchCondition(PosReq posreq) {
        if(posreq.getCity_id()!=0){
            posreq.setSheng_id(goodMapper.getShengId(posreq.getCity_id()));
        }
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list1 = goodMapper.getBrands_ids();
        List<Map<String, Object>> list2 = goodMapper.getFartherCategorys();
        if (null != list2 && list2.size() > 0) {
            List<Map<String, Object>> list2son = null;
            for (Map<String, Object> map2 : list2) {
                list2son = goodMapper.getSonCategorys(SysUtils.String2int("" + map2.get("id")));
                if(null != list2son && list2son.size() > 0){
                    map2.put("son", list2son);
                }
            }
        }
        List<Map<String, Object>> list3 = goodMapper.getPay_channel_ids(posreq);
        List<Map<String, Object>> list4 = goodMapper.getPay_card_ids();
        List<Map<String, Object>> list5 = goodMapper.getTrade_type_ids(posreq);
        List<Map<String, Object>> list6 = goodMapper.getSale_slip_ids();
        List<Map<String, Object>> list7 = goodMapper.getTDatesByCityId(posreq);
       // List<Map<String, Object>> list8 = goodMapper.getWebCategorys();
        map.put("brands", list1);
        map.put("category", list2);
       // map.put("webcategory", list8);
        map.put("pay_channel", list3);
        map.put("pay_card", list4);
        map.put("trade_type", list5);
        map.put("sale_slip", list6);
        map.put("tDate", list7);
        return map;
    }

    public String categorys(int category) {
        List<Integer> son = goodMapper.getSonCategoryIds(category);
        StringBuilder sb = new StringBuilder();
        sb.append("("+category+ ",");
        if (son != null && son.size() > 0) {
            for (Integer ii : son) {
                sb.append(ii + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public List<String> getValue(PosReq posreq) {
        return goodMapper.getValue(posreq);
    }

    public List<Map<String, Object>> getGoodImgUrl(int goodId){
    	List<Map<String, Object>> picList=goodMapper.getMobilePicList(goodId);
        if(picList!=null){
            for(int i=0;i<picList.size();i++){
            	if(picList.get(i).get("urlPath")!=null){
	            	String urlPath=filePath+picList.get(i).get("urlPath").toString();
	            	picList.get(i).put("urlPath", urlPath);
        		}
            }
        }
        return picList;
    }

    public Map<String, Object> goodshow(PosReq posreq) {
        Map<String, Object> goodInfoMap = null;
        // 商品信息
        Map<String, Object> goodinfo = goodMapper.getGoodById2(posreq.getGoodId());
        int id = SysUtils.String2int("" + goodinfo.get("id"));
        if (id > 0) {
            goodInfoMap = new HashMap<String, Object>();
            goodInfoMap.put("goodinfo", goodinfo);
            // 支付通道
            List<Map<String, Object>> payChannelList = goodMapper.getPayChannelListByGoodId(posreq);
            if (null != payChannelList && payChannelList.size() > 0) {
                goodInfoMap.put("payChannelList", payChannelList);
                int pcid=SysUtils.String2int("" +payChannelList.get(0).get("id"));
                goodInfoMap.put("paychannelinfo",pcService.payChannelInfo(pcid));
            }
            // 图片
            List<String> goodPics = goodMapper.getgoodPics(posreq.getGoodId());
            if(goodPics!=null&&goodPics.size()>0){
                for (int i = 0; i < goodPics.size(); i++) {
                    goodPics.set(i, filePath+ goodPics.get(i));
                }
            }
            goodInfoMap.put("goodPics", goodPics);
            // 评论数
            int commentsCount = cMapper.getCommentCount(posreq.getGoodId());
            goodInfoMap.put("commentsCount", commentsCount);
            // 生产厂家
            int factoryId = SysUtils.String2int("" + goodinfo.get("factory_id"));
            if (factoryId > 0) {
                Map<String, Object> factoryMap = goodMapper.getFactoryById(factoryId);
                if(factoryMap!=null){
                    factoryMap.put("logo_file_path", filePath+factoryMap.get("logo_file_path"));
                    goodInfoMap.put("factory", factoryMap);
                }
            }
            List<Map<String, Object>> relativeShopList = goodMapper.getRelativeShopListByGoodId(posreq);
            if (null != relativeShopList && relativeShopList.size() > 0) {
               for (Map<String, Object> map : relativeShopList) {
                   // 图片
                   List<String> goodPics2 = goodMapper.getgoodPics( SysUtils.String2int(map.get("id").toString()));
                   if (null != goodPics2 && goodPics2.size() > 0) {
                       map.put("url_path", filePath+goodPics2.get(0));
                   }
                   int openprice=0;
                   int googid=SysUtils.String2int(map.get("id").toString());
                   posreq.setGoodId(googid);
                   List<Map<String, Object>> pclist = goodMapper.getPayChannelListByGoodId(posreq);
                   if (null != pclist && pclist.size() > 0) {
                       openprice=SysUtils.String2int(pclist.get(0).get("opening_cost").toString()); 
                   }
                   map.put("retail_price", SysUtils.String2int(map.get("retail_price").toString())+openprice);
               }
            }
            goodInfoMap.put("relativeShopList",relativeShopList);
            
            List<Map<String, Object>> picList=goodMapper.getPicList(id);
            if(picList!=null){
                for(int i=0;i<picList.size();i++){
                    if(picList.get(i).get("urlPath")!=null){
                        String urlPath=filePath+picList.get(i).get("urlPath").toString();
                        picList.get(i).put("urlPath", urlPath);
                    }
                }
            }
            goodInfoMap.put("picList", picList);
            
        }
        return goodInfoMap;
    }    
}
