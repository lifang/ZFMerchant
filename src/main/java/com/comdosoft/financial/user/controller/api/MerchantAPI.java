package com.comdosoft.financial.user.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comdosoft.financial.user.domain.Response;
import com.comdosoft.financial.user.domain.zhangfu.Merchant;
import com.comdosoft.financial.user.domain.zhangfu.MyOrderReq;
import com.comdosoft.financial.user.service.CommonService;
import com.comdosoft.financial.user.service.MerchantService;
import com.comdosoft.financial.user.utils.HttpFile;

/**
 * 
 * 我的商户<br>
 * <功能描述>
 *
 * @author zengguang 2015年2月7日
 *
 */
@RestController
@RequestMapping(value = "api/merchant")
public class MerchantAPI {

    @Resource
    private MerchantService merchantService;

    @Resource
    private CommonService commonService;

    @Value("${userMerchant}")
    private String userMerchant;
    
    @Value("${filePath}")
    private String filePath;

    /**
     * 日志记录器
     */
    private static final Logger logger = Logger.getLogger(MerchantAPI.class);

    /**
     * 获取商户信息列表
     * 
     * @param customerId
     */
    @RequestMapping(value = "getList/{customerId}/{page}/{rows}", method = RequestMethod.POST)
    public Response getList(@PathVariable int customerId, @PathVariable int page, @PathVariable int rows) {
        Response sysResponse = null;
        try {
            Map<Object, Object> result = new HashMap<Object, Object>();
            result.put("total", merchantService.getListCount(customerId));
            result.put("list", merchantService.getList(customerId, page, rows));
            sysResponse = Response.getSuccess(result);
        } catch (Exception e) {
            logger.error("获取商户信息列表失败", e);
            sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    public Response findList(@RequestBody MyOrderReq req) {
        Response sysResponse = null;
        try {
            Map<Object, Object> result = new HashMap<Object, Object>();
            result.put("total", merchantService.findListCount(req));
            result.put("list", merchantService.findList(req));
            sysResponse = Response.getSuccess(result);
        } catch (Exception e) {
            logger.error("获取商户信息列表失败", e);
            sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
        }
        return sysResponse;
    }

    /**
     * 获取商户信息
     * 
     * @param id
     */
    @RequestMapping(value = "getOne/{id}", method = RequestMethod.POST)
    public Response getOne(@PathVariable int id) {
        Response sysResponse = null;
        try {
            sysResponse = Response.getSuccess(merchantService.findMerchantById(id));
        } catch (Exception e) {
            logger.error("获取商户信息失败", e);
            sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
        }
        return sysResponse;
    }
    
    @RequestMapping(value = "findMerchantById", method = RequestMethod.POST)
    public Response findMerchantById(@RequestBody MyOrderReq req) {
    	Response sysResponse = null;
    	try {
    		sysResponse = Response.getSuccess(merchantService.findMerchantById(req.getId()));
    	} catch (Exception e) {
    		logger.error("获取商户信息失败", e);
    		sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
    	}
    	return sysResponse;
    }

    /**
     * 新增商户信息
     * 
     * @param customer
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Response insert(@RequestBody Merchant param) {
        Response sysResponse = null;
        try {
        	String name = param.getTitle().trim();
        	Boolean b = merchantService.findMerchantByName(name);
        	if(b){
        		return Response.getError("该商户名已存在，无法创建");
        	}
            merchantService.insert(param);
            sysResponse = Response.getSuccess();
        } catch (Exception e) {
            logger.error("新增商户信息失败", e);
    		return Response.getError("该商户名已存在，无法创建");
        }
        return sysResponse;
    }

    /**
     * 修改商户信息
     * 
     * @param customer
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Response update(@RequestBody Merchant param) {
        Response sysResponse = null;
        try {
            merchantService.update(param);
            sysResponse = Response.getSuccess();
        } catch (Exception e) {
            logger.error("修改修改商户信息失败", e);
            sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
        }
        return sysResponse;
    }

    /**
     * 删除商户信息
     * 
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Response deleteAddress(@RequestBody Map<Object, Object> param) {
        Response sysResponse = null;
        try {
            List<Integer> ids = (ArrayList<Integer>) param.get("ids");
            for (int id : ids) {
                merchantService.delete(id);
            }
            sysResponse = Response.getSuccess();
        } catch (Exception e) {
            logger.error("删除商户信息失败", e);
            sysResponse = Response.getError("系统暂时无法处理您的请求,请重试");
        }
        return sysResponse;
    }

    /**
     * 上传文件接口
     * 
     * @param img
     * @param request
     * @return
     */
    @RequestMapping(value = "upload/file", method = RequestMethod.POST)
    public Response upload(MultipartFile fileImg, HttpServletRequest request) {
       	String result=HttpFile.upload(fileImg, userMerchant);
    	result = filePath + result;
        if(result.split("/").length>1){
            return Response.getSuccess(result);
        }else{
            return Response.getError(result);
        }
    }

}