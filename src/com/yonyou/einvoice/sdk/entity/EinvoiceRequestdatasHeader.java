package com.yonyou.einvoice.sdk.entity;

/**
 * @author huangshengxin
 * @date 2017年3月1日 
 * 发票请求头
 */
public class EinvoiceRequestdatasHeader extends EinvoiceObject {

	private static final long serialVersionUID = -1866204899898794355L;
	/**
	 * 发票请求流水号
	 */
	private String  FPQQLSH;
	/**
	 * 发票类型
	 */
	private String  FPLX;
	/**
	 * 销售方纳税人识别号 
	 */
	private String  XSF_NSRSBH;
	/**
	 * 销售方名称
	 */
	private String  XSF_MC;
	/**
	 * 销售方地址、电话
	 */
	private String  XSF_DZDH;
	/**
	 * 销售方银行账号
	 */
	private String  XSF_YHZH;
	/**
	 * 购买方纳税人识别号
	 */
	private String  GMF_NSRSBH;
	/**
	 * 购买方名称
	 */
	private String  GMF_MC;
	/**
	 * 购买方地址、电话
	 */
	private String  GMF_DZDH;
	/**
	 * 购买方银行账号
	 */
	private String  GMF_YHZH;
	/**
	 * 开票人
	 */
	private String  KPR;
	/**
	 * 收款人
	 */
	private String  SKR;
	/**
	 * 复核人
	 */
	private String  FHR;
	/**
	 * 备注
	 */
	private String  BZ;
	/**
	 * 请求来源唯一标识
	 */
	private String  LYID;
	/**
	 * 编码版本号
	 */
	private String  BMB_BBH;
	/**
	 * 开票点编码
	 */
	private String  ORGCODE;
	/**
	 * 价税合计
	 */
	private double JSHJ;
	/**
	 * 合计金额
	 */
	private double HJJE;
	/**
	 * 合计税额
	 */
	private double HJSE;
	public String getFPQQLSH() {
		return FPQQLSH;
	}
	public void setFPQQLSH(String fPQQLSH) {
		FPQQLSH = fPQQLSH;
	}
	public String getFPLX() {
		return FPLX;
	}
	public void setFPLX(String fPLX) {
		FPLX = fPLX;
	}
	public String getXSF_NSRSBH() {
		return XSF_NSRSBH;
	}
	public void setXSF_NSRSBH(String xSF_NSRSBH) {
		XSF_NSRSBH = xSF_NSRSBH;
	}
	public String getXSF_MC() {
		return XSF_MC;
	}
	public void setXSF_MC(String xSF_MC) {
		XSF_MC = xSF_MC;
	}
	public String getXSF_DZDH() {
		return XSF_DZDH;
	}
	public void setXSF_DZDH(String xSF_DZDH) {
		XSF_DZDH = xSF_DZDH;
	}
	public String getXSF_YHZH() {
		return XSF_YHZH;
	}
	public void setXSF_YHZH(String xSF_YHZH) {
		XSF_YHZH = xSF_YHZH;
	}
	public String getGMF_NSRSBH() {
		return GMF_NSRSBH;
	}
	public void setGMF_NSRSBH(String gMF_NSRSBH) {
		GMF_NSRSBH = gMF_NSRSBH;
	}
	public String getGMF_MC() {
		return GMF_MC;
	}
	public void setGMF_MC(String gMF_MC) {
		GMF_MC = gMF_MC;
	}
	public String getGMF_DZDH() {
		return GMF_DZDH;
	}
	public void setGMF_DZDH(String gMF_DZDH) {
		GMF_DZDH = gMF_DZDH;
	}
	public String getGMF_YHZH() {
		return GMF_YHZH;
	}
	public void setGMF_YHZH(String gMF_YHZH) {
		GMF_YHZH = gMF_YHZH;
	}
	public String getKPR() {
		return KPR;
	}
	public void setKPR(String kPR) {
		KPR = kPR;
	}
	public String getSKR() {
		return SKR;
	}
	public void setSKR(String sKR) {
		SKR = sKR;
	}
	public String getFHR() {
		return FHR;
	}
	public void setFHR(String fHR) {
		FHR = fHR;
	}
	public String getBZ() {
		return BZ;
	}
	public void setBZ(String bZ) {
		BZ = bZ;
	}
	public String getLYID() {
		return LYID;
	}
	public void setLYID(String lYID) {
		LYID = lYID;
	}
	public String getBMB_BBH() {
		return BMB_BBH;
	}
	public void setBMB_BBH(String bMB_BBH) {
		BMB_BBH = bMB_BBH;
	}
	public String getORGCODE() {
		return ORGCODE;
	}
	public void setORGCODE(String oRGCODE) {
		ORGCODE = oRGCODE;
	}
	public double getJSHJ() {
		return JSHJ;
	}
	public void setJSHJ(double jSHJ) {
		JSHJ = jSHJ;
	}
	public double getHJJE() {
		return HJJE;
	}
	public void setHJJE(double hJJE) {
		HJJE = hJJE;
	}
	public double getHJSE() {
		return HJSE;
	}
	public void setHJSE(double hJSE) {
		HJSE = hJSE;
	}
	
	
}
