package com.yonyou.einvoice.sdk.entity.conponents;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月4日 
*/
public class EinvoiceRedRetroRequestdatas extends EinvoiceObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5950349487319318001L;
	/**
	 * 发票请求流水号
	 */
	private String FPQQLSH;
	/**
	 * 蓝字发票代码
	 */
	private String fpDm;
	/**
	 * 蓝字发票号码
	 */
	private String fpHm;
	/**
	 * 开票点编码
	 */
	private String ORGCODE;
	
	public String getFPQQLSH() {
		return FPQQLSH;
	}
	public void setFPQQLSH(String fPQQLSH) {
		FPQQLSH = fPQQLSH;
	}
	public String getFpDm() {
		return fpDm;
	}
	public void setFpDm(String fpDm) {
		this.fpDm = fpDm;
	}
	public String getFpHm() {
		return fpHm;
	}
	public void setFpHm(String fpHm) {
		this.fpHm = fpHm;
	}
	public String getORGCODE() {
		return ORGCODE;
	}
	public void setORGCODE(String oRGCODE) {
		ORGCODE = oRGCODE;
	}
}
