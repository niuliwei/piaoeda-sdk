package com.yonyou.einvoice.sdk.service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.yonyou.einvoice.sdk.utils.HttpRequestUtils;
import com.yonyou.einvoice.sdk.utils.MapBuilder;

import net.sf.json.JSONObject;
/**
 * @author huangshengxin
 * @date 2017年3月2日 
*/
public class RequestService {

	public String  sendPost(String apiURL, Object obj) throws Exception  {
		Map<String, String> map = MapBuilder.buildPostParam(obj);
		return HttpRequestUtils.formPostRequest(apiURL, map);
		 
	}
	
	public String sendGet(String apiURL, Object obj) throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException  {
		Map<String, String> map = MapBuilder.buildGetParam(obj);
		return HttpRequestUtils.formGetRequest(apiURL,map);
	}
	
	/*public JSONObject sendGet(String apiURL, String param) throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException  {
		//Map<String, String> map = MapBuilder.buildGetParam(obj);
		return HttpRequestUtils.formGetRequest(apiURL,map);
	}*/
}
