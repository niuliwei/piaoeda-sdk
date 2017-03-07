package com.yonyou.einvoice.sdk.entity.results;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月3日 
 * 返回的结果对象
 */
public class EinvoiceBaseResult extends EinvoiceObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8176360673613839003L;
	/**
	 * 状态码
	 */
	protected String code;
	/**
	 * 信息说明
	 */
	protected String msg;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "EinvoiceBaseResult [code=" + code + ", msg=" + msg + "]";
	}
	
}
