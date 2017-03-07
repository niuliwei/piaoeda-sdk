package com.yonyou.einvoice.sdk.entity.conponents;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月5日 
 * 开票申请开票
*/
public class EinvoiceManualOperationRequestData extends EinvoiceObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1932819435847540687L;
	
	/**
	 * 发票请求流水号
	 */
	private String FPQQLSH;
	/**
	 * 销售方纳税人识别号
	 */
	private String XSF_NSRSBH;
	/**
	 * 价税合计
	 */
	private double JSHJ;
	/*public EinvoiceManualOperationRequestData(String fpqqlsh2, String xsf_NSRSBH2, double jshj2) {
		// TODO Auto-generated constructor stub
		this.FPQQLSH =fpqqlsh2;
		this.XSF_NSRSBH = xsf_NSRSBH2;
		this.JSHJ = jshj2;
	}*/
	public String getFPQQLSH() {
		return FPQQLSH;
	}
	public void setFPQQLSH(String fPQQLSH) {
		FPQQLSH = fPQQLSH;
	}
	public String getXSF_NSRSBH() {
		return XSF_NSRSBH;
	}
	public void setXSF_NSRSBH(String xSF_NSRSBH) {
		XSF_NSRSBH = xSF_NSRSBH;
	}
	public double getJSHJ() {
		return JSHJ;
	}
	public void setJSHJ(double jSHJ) {
		JSHJ = jSHJ;
	}
	
}
