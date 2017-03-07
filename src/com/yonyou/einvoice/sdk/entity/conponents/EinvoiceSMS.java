package com.yonyou.einvoice.sdk.entity.conponents;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月1日 
 * 短信配置
 */
public class EinvoiceSMS extends EinvoiceObject {

	private static final long serialVersionUID = 6597339351327741108L;
	
	/**
	 * 发票请求流水号
	 */
	private String  fpqqlsh;
	/**
	 * 接收地址
	 */
	private String  address;
	/**
	 * 标题
	 */
	private String  title;
	/**
	 * 消息内容
	 */
	private String  content;
	public String getFpqqlsh() {
		return fpqqlsh;
	}
	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
