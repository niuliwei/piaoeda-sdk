package com.yonyou.einvoice.sdk.utils;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * @author yangbao
 *
 */
public class HttpRequestUtils {

	/**
	 * POST 请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public static String formPostRequest(String url, Map<String, String> map)
			throws Exception {
		//SSLContext sslContext = SSLContexts.custom().build();
		//HttpClient httpClient = HttpClients.custom().setSslcontext(sslContext).build();
		HttpClient httpClient = HttpClients.custom().build();
		HttpPost httpPost = new HttpPost(url);
		//httpPost.
		//签名
		String sign = MapBuilder.sign(map);
		httpPost.addHeader("sign", sign);
		
		List<NameValuePair> list = new ArrayList<NameValuePair>();
	    Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
	    while (iterator.hasNext()) {
	      Entry<String, String> elem = iterator.next();
	      list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
	    }
	    if (list.size() > 0) {
	      UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
	      httpPost.setEntity(entity);
	    }
		HttpResponse response = httpClient.execute(httpPost);
		return responseResult(response);
	}

	 
	/**
	 * GET 请求
	 *
	 * @param url
	 * @param map
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws ClientProtocolException 
	 * @throws IOException
	 */
	public static String formGetRequest(String url, Map<String, String> map)
			throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
		SSLContext sslContext = SSLContexts.custom().build();
		HttpClient httpClient = HttpClients.custom().setSslcontext(sslContext).build();
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		StringBuffer urlwithparams = new StringBuffer();
		urlwithparams.append(url + "?");
		while (iterator.hasNext()) {
			Entry<String, String> elem = iterator.next();
			urlwithparams.append(elem.getKey() + "=" + elem.getValue() + "&");
		}
		urlwithparams.deleteCharAt(urlwithparams.length()-1);
		HttpGet httpGet = new HttpGet(urlwithparams.toString());
		HttpResponse response = httpClient.execute(httpGet);
		return responseResult(response);

	}

	private static String responseResult(HttpResponse response) throws IOException {
		 String result = "";
		    if (response != null) {
		      HttpEntity resEntity = response.getEntity();
		      if (resEntity != null) {
		        result = EntityUtils.toString(resEntity, "UTF-8");
		//JSONObject.
		return result;
	}
		    }
			return result;
	}
}
