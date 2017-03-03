package com.yonyou.einvoice.sdk.entity;

import java.util.List;

/**
 * @author huangshengxin
 * @since 2017年3月1日 
 */
public class EinvoiceBlueApply extends EinvoiceObject {

	private static final long serialVersionUID = -8240249784821927138L;
	
	/**
	 * 开票申请发票信息，包含发票头、发票明细
	 */
	private List<EinvoiceRequestdatas> requestdatas;
	/**
	 * 邮件推送配置(可选)
	 */
	private List<EinvoiceEmail> email;
	/**
	 * 短信推送配置(可选)
	 */
	private List<EinvoiceSMS> sms;
	/**
	 * 回调服务配置(可选)
	 */
	private List<EinvoiceURL> url;
	/**
	 * 是否自动审核(可选)
	 */
	private boolean autoAudit;
	public List<EinvoiceRequestdatas> getRequestdatas() {
		return requestdatas;
	}
	public void setRequestdatas(List<EinvoiceRequestdatas> requestdatas) {
		this.requestdatas = requestdatas;
	}
	public List<EinvoiceEmail> getEmail() {
		return email;
	}
	public void setEmail(List<EinvoiceEmail> email) {
		this.email = email;
	}
	public List<EinvoiceSMS> getSms() {
		return sms;
	}
	public void setSms(List<EinvoiceSMS> sms) {
		this.sms = sms;
	}
	public List<EinvoiceURL> getUrl() {
		return url;
	}
	public void setUrl(List<EinvoiceURL> url) {
		this.url = url;
	}
	public boolean isAutoAudit() {
		return autoAudit;
	}
	public void setAutoAudit(boolean autoAudit) {
		this.autoAudit = autoAudit;
	}
	
}
