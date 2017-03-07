package com.yonyou.einvoice.sdk.entity;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRedRetroRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceURL;

/**
 * @author huangshengxin
 * @date 2017年3月3日 
 * 冲红发票实体类
*/
public class EinvoiceRedRetro extends EinvoiceObject {

	private static final long serialVersionUID = 2945519337833951447L;
	
	/**
	 * 发票冲红参数
	 */
	private List<EinvoiceRedRetroRequestdatas> requestdatas;
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
	
	private boolean autoAudit = true;
	
	public List<EinvoiceRedRetroRequestdatas> getRequestdatas() {
		return requestdatas;
	}
	public void setRequestdatas(List<EinvoiceRedRetroRequestdatas> requestdatas) {
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
