package com.comdosoft.financial.user.controller.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comdosoft.financial.user.domain.Response;
import com.comdosoft.financial.user.domain.query.CommentReq;
import com.comdosoft.financial.user.service.CommentService;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @Value("${uploadPictureTempsPath}")
    private String uploadPictureTempsPath;


    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Response getGoodsList(@RequestBody CommentReq req) {
        Response response = new Response();
        Map<String, Object> pcInfo = commentService.getList(req);
        response.setCode(Response.SUCCESS_CODE);
        response.setResult(pcInfo);
        return response;
    }

    /**
     * 上传图片文件
     * 
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping(value = "upload/tempImage", method = RequestMethod.POST)
    public Response tempImage(@RequestParam(value = "img") MultipartFile img, HttpServletRequest request) {
        try {
        	String uploadFilePath = uploadPictureTempsPath;
            return Response.getSuccess(commentService.saveTmpImage(uploadFilePath,img, request));
        } catch (IOException e) {
            return Response.getError("请求失败！");
        }
    }

    /**
     * 下载模板文件
     * 
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping(value = "downLoadManagerTemplate", method = RequestMethod.POST)
    public Response downLoadManagerTemplate(@RequestBody Map<Object, Object> map, HttpServletRequest request, HttpServletResponse response) {
        try {
            commentService.downLoadManagerTemplate(request, response, map);
            return Response.getSuccess("下载模板失败！");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getError("下载模板失败！");
        } finally {
        }
    }
    
    @Value("${appVersionPath}")
    private String appVersionPath;

    @RequestMapping(value = "appVersion",produces="application/json;charset=UTF-8", method = RequestMethod.POST)
    public String appVersion() {
        File file = new File(appVersionPath);
        BufferedReader reader = null;
        StringBuilder sb=new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"code\":-1,\"message\":\"系统出错\"}";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
