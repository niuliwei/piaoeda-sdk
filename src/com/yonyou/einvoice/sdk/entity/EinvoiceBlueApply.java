package com.yonyou.einvoice.sdk.entity;


/**
 * @author huangshengxin
 * @since 2017年3月1日 
 */
public class EinvoiceBlueApply extends EinvoiceObject {

	private static final long serialVersionUID = -8240249784821927138L;
	
	/**
	 * 开票申请发票信息，包含发票头、发票明细
	 */
	private EinvoiceRequestdatas requestdatas;
	/**
	 * 邮件推送配置(可选)
	 */
	private EinvoiceEmailAndSMS email;
	/**
	 * 短信推送配置(可选)
	 */
	private EinvoiceEmailAndSMS sms;
	/**
	 * 回调服务配置(可选)
	 */
	private EinvoiceURL url;
	/**
	 * 是否自动审核(可选)
	 */
	private boolean autoAudit;
	
	
	public EinvoiceRequestdatas getRequestdatas() {
		return requestdatas;
	}
	public void setRequestdatas(EinvoiceRequestdatas requestdatas) {
		this.requestdatas = requestdatas;
	}
	public EinvoiceEmailAndSMS getEmail() {
		return email;
	}
	public void setEmail(EinvoiceEmailAndSMS email) {
		this.email = email;
	}
	public EinvoiceEmailAndSMS getSms() {
		return sms;
	}
	public void setSms(EinvoiceEmailAndSMS sms) {
		this.sms = sms;
	}
	public EinvoiceURL getUrl() {
		return url;
	}
	public void setUrl(EinvoiceURL url) {
		this.url = url;
	}
	public boolean isAutoAudit() {
		return autoAudit;
	}
	public void setAutoAudit(boolean autoAudit) {
		this.autoAudit = autoAudit;
	}
}
