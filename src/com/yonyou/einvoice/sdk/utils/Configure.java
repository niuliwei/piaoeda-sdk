package com.yonyou.einvoice.sdk.utils;

/**
 * User: huangshengxin
 * Date: 2017-3-2
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
	
	public static final String APPID = "commontesterCA";
	
	//public static final String HttpsRequestClassName = "com.yonyou.einvoice.sdk.utils.HttpRequestUtils";
	//以下是几个API的路径：
	//1）申请开蓝票API
	public static final String APPLY_BLUE_INVOICE_API = "http://www.yesfp.com/invoiceclient-web/api/invoiceApply/insertWithArray?appid="+APPID;
	//2）开票状态查询服务API
	public static final String PROCEDURE_STATUS_QUERY_API="http://www.yesfp.com/invoiceclient-web/api/invoiceApply/queryInvoiceStatus?appid="+APPID;
	//3）冲红发票申请API
	public static final String RED_INVOICE_RETROGRADATION = "http://www.yesfp.com/invoiceclient-web/api/invoiceApply/red?appid="+APPID;
	
	
}
