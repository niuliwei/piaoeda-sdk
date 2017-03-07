package com.yonyou.einvoice.sdk.entity.conponents;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月1日 
 * 回调服务
 */
public class EinvoiceURL extends EinvoiceObject {

	private static final long serialVersionUID = -3989848523016749631L;
	/**
	 * 发票请求流水号
	 */
	private String fpqqlsh;
	/**
	 * 回调url
	 */
	private String url;
	
	public String getFpqqlsh() {
		return fpqqlsh;
	}
	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
