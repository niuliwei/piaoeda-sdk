package com.yonyou.einvoice.sdk.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.EinvoiceManualOperation;
import com.yonyou.einvoice.sdk.entity.EinvoiceQueryStatus;
import com.yonyou.einvoice.sdk.entity.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceManualOperationRequestData;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRedRetroRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatasInventory;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceURL;


/**
 * @author huangshengxin
 * @date 2017年3月4日 用于构建http请求的参数
 */
public class ParamBuilder {

	public Map<String, String> buildAllpyParamMap(EinvoiceBlueApply einvoiceBlueApply) {
		
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("requestdatas", buildRequestDatas(einvoiceBlueApply.getRequestdatas()));
		paramsMap.put("email", buildEmailConfigs(einvoiceBlueApply.getEmail()));
		paramsMap.put("sms", buildSmsConfigs(einvoiceBlueApply.getSms()));
		paramsMap.put("url", buildUrlConfigs(einvoiceBlueApply.getUrl()));
		paramsMap.put("autoAudit", String.valueOf(einvoiceBlueApply.isAutoAudit()));
		return paramsMap;
	}

	public Map<String, String> buildRedRetroParamMap(EinvoiceRedRetro einvoiceRedRetro) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("requestdatas", buildRedRetroRequestDatas(einvoiceRedRetro.getRequestdatas()));
		paramsMap.put("email", buildEmailConfigs(einvoiceRedRetro.getEmail()));
		paramsMap.put("sms", buildSmsConfigs(einvoiceRedRetro.getSms()));
		paramsMap.put("url", buildUrlConfigs(einvoiceRedRetro.getUrl()));
		paramsMap.put("autoAudit", "true");

		return paramsMap;
		
	}

	public Map<String, String> buildStatusQueryParam(EinvoiceQueryStatus einvoiceQueryStatus) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("fpqqlsh", einvoiceQueryStatus.getFpqqlsh());
		return paramsMap;
	}

	public Map<String, String> buildManualOperationParamMap(EinvoiceManualOperation operation) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("requestdatas", buildManualOperationRequestdata(operation.getEinvoiceManualOperationRequestData()));
		return paramsMap;
	}


	private String buildManualOperationRequestdata(
			List<EinvoiceManualOperationRequestData> einvoiceManualOperationRequestData) {
		
		List<Map<String, Object>> datas = new ArrayList<>();
		for (EinvoiceManualOperationRequestData requestData : einvoiceManualOperationRequestData) {
			Map<String, Object> map = new HashMap<>();
			map.put("FPQQLSH", requestData.getFPQQLSH());
			map.put("XSF_NSRSBH", requestData.getXSF_NSRSBH());
			map.put("JSHJ", requestData.getJSHJ());
			datas.add(map);
		}
	
		GsonBuilder builder = new GsonBuilder();
		return builder.create().toJson(datas);
	}

	private String buildRedRetroRequestDatas(List<EinvoiceRedRetroRequestdatas> requestdatas) {
		if(requestdatas==null){
			throw new RuntimeException("requestdatas参数不能为空！");
		}
		List<Map<String, Object>> datas = new ArrayList<>();
		for (EinvoiceRedRetroRequestdatas redRetroRequestdata : requestdatas) {
			Map<String, Object> map = new HashMap<>();
			map.put("FPQQLSH", redRetroRequestdata.getFPQQLSH());
			map.put("fpDm", redRetroRequestdata.getFpDm());
			map.put("fpHm", redRetroRequestdata.getFpHm());
			map.put("ORGCODE", redRetroRequestdata.getORGCODE());
			datas.add(map);
		}
	
		GsonBuilder builder = new GsonBuilder();
		return builder.create().toJson(datas);
	
	}

	private String buildUrlConfigs(List<EinvoiceURL> urls) {

		if (urls!=null) {
			List<Map<String, Object>> datas = new ArrayList<>();
			for (EinvoiceURL url : urls) {
				Map<String, Object> map = new HashMap<>();
				map.put("fpqqlsh", url.getFpqqlsh());
				map.put("url", url.getUrl());
				datas.add(map);
			}
			GsonBuilder builder = new GsonBuilder();
			return builder.create().toJson(datas);
		}
		return null;
	}

	/**
	 * 构造短信发送信息
	 * 
	 * @param einvoiceBlueApply
	 * 
	 * @return
	 */
	private String buildSmsConfigs(List<EinvoiceSMS> smses) {
		if (smses!=null) {
			List<Map<String, Object>> datas = new ArrayList<>();
			for (EinvoiceSMS sms : smses) {
				Map<String, Object> map = new HashMap<>();
				map.put("fpqqlsh", sms.getFpqqlsh());
				map.put("address", sms.getAddress());
				map.put("title", sms.getTitle());
				map.put("content", sms.getContent());
				datas.add(map);
			}
			GsonBuilder builder = new GsonBuilder();
			return builder.create().toJson(datas);
		}
		return null;
	}

	/**
	 * 构造email发送信息
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	private String buildEmailConfigs(List<EinvoiceEmail> emails) {

		if (emails!=null) {
			List<Map<String, Object>> datas = new ArrayList<>();
			for (EinvoiceEmail email : emails) {
				Map<String, Object> map = new HashMap<>();
				//if (email.getFpqqlsh()!=null) {
					map.put("fpqqlsh", email.getFpqqlsh());
				//}
				map.put("address", email.getAddress());
				map.put("title", email.getTitle());
				map.put("content", email.getContent());
				datas.add(map);
			}
			GsonBuilder builder = new GsonBuilder();
			return builder.create().toJson(datas);
		}
		return null;

	}

	/**
	 * 构造requestdatas
	 * 
	 * @param einvoiceBlueApply
	 * 
	 * @return
	 */
	private String buildRequestDatas(List<EinvoiceRequestdatas> einvoiceRequestdatas) {
		
		if(einvoiceRequestdatas==null){
			throw new RuntimeException("requestdatas参数不能为空");
		}
		List<Map<String, Object>> datas = new ArrayList<>();
		for (EinvoiceRequestdatas requestdata : einvoiceRequestdatas) {
			Map<String, Object> map = new HashMap<>();
			map.put("FPQQLSH", requestdata.getFPQQLSH());
			map.put("XSF_NSRSBH", requestdata.getXSF_NSRSBH());
			map.put("XSF_MC", requestdata.getXSF_MC());
			map.put("XSF_DZDH", requestdata.getXSF_DZDH());
		 map.put("XSF_YHZH", requestdata.getXSF_YHZH());
			 map.put("GMF_NSRSBH", requestdata.getGMF_NSRSBH());
			map.put("GMF_MC", requestdata.getGMF_MC());
			 map.put("GMF_DZDH", requestdata.getGMF_DZDH());
			 map.put("GMF_YHZH", requestdata.getGMF_YHZH());
			 map.put("KPR", requestdata.getKPR());
			 map.put("SKR", requestdata.getSKR());
			 map.put("FHR", requestdata.getFHR());
			map.put("JSHJ", requestdata.getJSHJ());
			 map.put("HJJE", requestdata.getHJJE());
			 map.put("HJSE", requestdata.getHJSE());
			 map.put("BZ", requestdata.getBZ());
			 map.put("BMB_BBH", requestdata.getBMB_BBH());
			 map.put("BZ", requestdata.getBZ());
			map.put("items", buildItems(requestdata.getItem()));
			datas.add(map);
		}

		GsonBuilder builder = new GsonBuilder();
		return builder.create().toJson(datas);
	}

	/**
	 * 构造request发票明细
	 * 
	 * @param list
	 * 
	 * @return
	 */
	private  List<Map<String, Object>> buildItems(List<EinvoiceRequestdatasInventory> inventories) {

		List<Map<String, Object>> datas = new ArrayList<>();
		for (EinvoiceRequestdatasInventory inventory : inventories) {
			Map<String, Object> map = new HashMap<>();
			 map.put("FPHXZ",inventory.getFPHXZ());
			map.put("XMMC", inventory.getXMMC());
			 map.put("GGXH",inventory.getGGXH());
			 map.put("DW",inventory.getDW());
			 map.put("XMSL",inventory.getXMSL());
			 map.put("XMDJ",inventory.getXMDJ());
			 map.put("XMJE",inventory.getXMJE());
			map.put("XMJSHJ", inventory.getXMJSHJ());
			map.put("SL", inventory.getSL());
			 map.put("SE",inventory.getSE());
			 map.put("HH",inventory.getHH());
			 map.put("ZKHHH",inventory.getZKHHH());
			 map.put("SPBM",inventory.getSPBM());
			 map.put("ZXBM",inventory.getZXBM());
			 map.put("YHZCBS",inventory.getYHZCBS());
			 map.put("LSLBS",inventory.getLSBS());
			 map.put("ZZSTSGL",inventory.getZZSTSGL());
			 map.put("KCE",inventory.getKCE());
			datas.add(map);
		}
		return datas;
	}

}
