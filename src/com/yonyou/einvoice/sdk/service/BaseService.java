package com.yonyou.einvoice.sdk.service;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import com.google.gson.JsonObject;
import com.yonyou.einvoice.sdk.utils.Configure;

import net.sf.json.JSONObject;

/**
 * User: rizenguo
 * Date: 2014/12/10
 * Time: 15:44
 * 服务的基类
 */
public class BaseService{

    //API的地址
    private String apiURL;

    //发请求的HTTPS请求器
    private RequestService requestService;
    
    //private String resultJson;

    public BaseService(String apiURL) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.apiURL = apiURL;
        requestService = new RequestService();
    }

    protected String sendPost(Object Obj) throws Exception {
        return requestService.sendPost(apiURL,Obj);
    }
    
    protected String sendGet(Object Obj) throws Exception {
        return requestService.sendGet(apiURL,Obj);
    }
    
    
    
    /**
     * 供商户想自定义自己的HTTP请求器用
     * @param request 实现了IserviceRequest接口的HttpsRequest
     */
    public void setServiceRequest(RequestService request){
    	requestService = request;
    }
}
