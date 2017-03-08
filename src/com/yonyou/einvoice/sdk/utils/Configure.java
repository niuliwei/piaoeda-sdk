package com.yonyou.einvoice.sdk.utils;

import java.util.ResourceBundle;


/**
 * User: huangshengxin
 * Date: 2017-3-2
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
	
	public static void init() {
		ResourceBundle bundle = ResourceBundle
			     .getBundle("config_zh_CN");
		String userCenterUrl = bundle.getString("userCenterUrl").trim();
		String APPID =  bundle.getString("APPID").trim();
		APPLY_BLUE_INVOICE_API = userCenterUrl+bundle.getString("APPLY_BLUE_INVOICE_API").trim()+APPID;
		PROCEDURE_STATUS_QUERY_API = userCenterUrl+bundle.getString("PROCEDURE_STATUS_QUERY_API").trim()+APPID;
		RED_INVOICE_RETROGRADATION = userCenterUrl+bundle.getString("RED_INVOICE_RETROGRADATION").trim()+APPID;
		MANUAL_OPERATION_API = userCenterUrl+bundle.getString("MANUAL_OPERATION_API").trim()+APPID;
		PASSWORD = bundle.getString("PASSWORD").trim();
		
	} 
	
	//public static final String APPID = "commontesterCA";
	
	
	//######################################################################################
	//以下是几个API的路径：
	//1）申请开蓝票API
	public static String APPLY_BLUE_INVOICE_API;// = //"http://www.yesfp.com/invoiceclient-web/api/invoiceApply/insertWithArray?appid="+APPID;
	//2）开票状态查询服务API
	public static  String PROCEDURE_STATUS_QUERY_API;//="http://www.yesfp.com/invoiceclient-web/api/invoiceApply/queryInvoiceStatus?appid="+APPID;
	//3）冲红发票申请API
	public static  String RED_INVOICE_RETROGRADATION;// = "http://www.yesfp.com/invoiceclient-web/api/invoiceApply/red?appid="+APPID;
	//4)开票申请开票API
	public static  String MANUAL_OPERATION_API;// = "http://www.yesfp.com/invoiceclient-web/api/invoiceApply/issue?appid="+APPID;
	//5)直接开票API
	//public static final String APPLY_BLUE_INVOICE_API = "http://www.yesfp.com/invoiceclient-web/api/invoiceApplyDemo/insertAndApply?appid="+APPID;
	//6)直接发票冲红url
	//public static final String RED_INVOICE_RETROGRADATION = "http://www.yesfp.com/invoiceclient-web/api/invoiceApplyDemo/red?appid="+APPID;
	
	//######################################################################################
	//密码
	public static  String PASSWORD;// = "http://www.yesfp.com/invoiceclient-web/api/invoiceApply/issue?appid="+APPID;
}
