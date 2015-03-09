package com.comdosoft.financial.user.controller.api;

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
import com.comdosoft.financial.user.service.CommonService;
import com.comdosoft.financial.user.service.MerchantService;

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

    @Value("${uploadMerchantFilePath}")
    private String uploadMerchantFilePath;

    /**
     * 日志记录器
     */
    private static final Logger logger = Logger.getLogger(MerchantAPI.class);

    /**
     * 获取商户信息列表
     * 
     * @param customerId
     */
    @RequestMapping(value = "getList/{customerId}/{page}/{rows}", method = RequestMethod.GET)
    public Response getList(@PathVariable int customerId, @PathVariable int page, @PathVariable int rows) {
        Response sysResponse = null;
        try {
            sysResponse = Response.getSuccess(merchantService.getList(customerId, page, rows));
        } catch (Exception e) {
            logger.error("获取商户信息列表失败", e);
            sysResponse = Response.getError("获取商户信息列表失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * 获取商户信息
     * 
     * @param id
     */
    @RequestMapping(value = "getOne/{id}", method = RequestMethod.GET)
    public Response getOne(@PathVariable int id) {
        Response sysResponse = null;
        try {
            sysResponse = Response.getSuccess(merchantService.getOne(id));
        } catch (Exception e) {
            logger.error("获取商户信息失败", e);
            sysResponse = Response.getError("获取商户信息失败:系统异常");
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
            merchantService.insert(param);
            sysResponse = Response.getSuccess();
        } catch (Exception e) {
            logger.error("新增商户信息失败", e);
            sysResponse = Response.getError("新增商户信息失败:系统异常");
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
            sysResponse = Response.getError("修改修改商户信息失败:系统异常");
        }
        return sysResponse;
    }

    /**
     * 删除商户信息
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Response deleteAddress(@RequestBody int[] ids) {
        Response sysResponse = null;
        try {
            for (int id : ids) {
                merchantService.delete(id);
            }
            sysResponse = Response.getSuccess();
        } catch (Exception e) {
            logger.error("删除商户信息失败", e);
            sysResponse = Response.getError("删除商户信息失败:系统异常");
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
    public Response upload(MultipartFile fileName, HttpServletRequest request) {
        Response sysResponse = null;
        try {
            String path = commonService.saveTmpImage(request, fileName, uploadMerchantFilePath);
            sysResponse = Response.getSuccess(path);
        } catch (Exception e) {
            logger.error("上传文件失败", e);
            sysResponse = Response.getError("上传文件失败:系统异常");
        }
        return sysResponse;
    }

}