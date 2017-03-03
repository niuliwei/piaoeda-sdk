package com.yonyou.einvoice.sdk.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
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

import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.utils.Configure;

import net.sf.json.JSONObject;

/**
 * @author huangshengxin
 * @date 2017年3月2日 
*/
public class BlueInvoiceService extends BaseService{
	
	public BlueInvoiceService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.APPLY_BLUE_INVOICE_API);
	}

	public String applyBlueinvoice(EinvoiceBlueApply einvoiceBlueApply) throws Exception {
		return this.sendPost(einvoiceBlueApply);
	}		
}
