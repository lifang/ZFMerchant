package com.comdosoft.financial.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.comdosoft.financial.user.domain.query.CartReq;
import com.comdosoft.financial.user.mapper.zhangfu.GoodMapper;
import com.comdosoft.financial.user.mapper.zhangfu.ShopCartMapper;
import com.comdosoft.financial.user.utils.SysUtils;

@Service
public class ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Value("${filePath}")
    private String filePath;
    
    public List<?> getList(CartReq cartreq) {
        List<Map<String,Object>> mapList=shopCartMapper.getList(cartreq);
        for (Map<String, Object> map : mapList) {
            int goodId =SysUtils.String2int(""+map.get("goodId")); 
            //图片
            List<String> goodPics=goodMapper.getgoodPics(goodId);
            if(null!=goodPics&&goodPics.size()>0){
                map.put("url_path",filePath+goodPics.get(0));
            }
        }
        return mapList;
    }

    public int delete(int cartId) {
        try {
            shopCartMapper.delete(cartId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int add(CartReq cartreq) {
        try {
            int quantity=shopCartMapper.isExist(cartreq);
            if(0==quantity){
                shopCartMapper.add(cartreq);
            }else{
                cartreq.setQuantity(quantity+cartreq.getQuantity());
                shopCartMapper.update2(cartreq);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(CartReq cartreq) {
        try {
            shopCartMapper.update(cartreq);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getTotal(CartReq cartreq) {
        return shopCartMapper.getTotal(cartreq);
    }

}
