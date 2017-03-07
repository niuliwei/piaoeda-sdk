package com.yonyou.einvoice.sdk.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * @author huangshengxin
 * @date 2017年3月4日
 */
public class HttpRequestProcessor {

	public static String sendPost(String apiURL, Map<String, String> paramsMap) throws Exception {
		HttpClient httpClient = HttpClients.custom().build();
		HttpPost httpPost = new HttpPost(apiURL);
		
		 // 签名
	    String sign = Signature.sign(paramsMap);
	    httpPost.addHeader("sign", sign);

		// 转换POST表单参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> iterator = paramsMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> elem = iterator.next();
			list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
		}
		if (list.size() > 0) {
			UrlEncodedFormEntity entity;
			entity = new UrlEncodedFormEntity(list, "UTF-8");
			httpPost.setEntity(entity);
		}

		// 发送http post请求，并得到响应结果
		HttpResponse response = httpClient.execute(httpPost);
		String result = "";
		if (response != null) {
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				result = EntityUtils.toString(resEntity, "UTF-8");
			}
		}
		return result;
	}

	public static String sendGet(String apiURL, Map<String, String> paramsMap) {
		//暂时没有get请求的需求
		return null;
	}
}
