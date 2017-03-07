package com.yonyou.einvoice.sdk.entity.conponents;

import com.yonyou.einvoice.sdk.entity.EinvoiceObject;

/**
 * @author huangshengxin
 * @date 2017年3月1日 
 * 发票明细
 */
public class EinvoiceRequestdatasInventory extends EinvoiceObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788777954268763275L;
	
	/**
	* 发票行性质
	*/
	private int FPHXZ;
	/**
	 * 项目名称
	 */
	private String XMMC;
	/**
	 * 规格型号
	 */
	private String GGXH;
	/**
	 * 单位
	 */
	private String DW;
	/**
	 * 项目数量
	 */
	private double XMSL;
	/**
	 * 项目单价
	 */
	private double XMDJ;
	/**
	 * 项目金额
	 */
	private double XMJE; 
	/**
	 * 项目价税合计
	 */
	private double XMJSHJ; 
	/**
	 * 税率
	 */
	private double SL; 
	/**
	 * 税额
	 */
	private double SE; 
	/**
	 * 行号
	 */
	private String HH;
	/**
	 * 折扣行行号
	 */
	private String ZKHHH;
	/**
	 * 商品编码
	 */
	private String SPBM;
	/**
	 * 商品自行编码
	 */
	private String ZXBM;
	/**
	 * 销售优惠标识
	 */
	private int YHZCBS;
	/**
	 * 零税率标识
	 */
	private String LSBS;
	/**
	 * 优惠政策说明
	 */
	private String ZZSTSGL;
	/**
	 * 扣除额
	 */
	private double KCE;
	public int getFPHXZ() {
		return FPHXZ;
	}
	public void setFPHXZ(int fPHXZ) {
		FPHXZ = fPHXZ;
	}
	public String getXMMC() {
		return XMMC;
	}
	public void setXMMC(String xMMC) {
		XMMC = xMMC;
	}
	public String getGGXH() {
		return GGXH;
	}
	public void setGGXH(String gGXH) {
		GGXH = gGXH;
	}
	public String getDW() {
		return DW;
	}
	public void setDW(String dW) {
		DW = dW;
	}
	public double getXMSL() {
		return XMSL;
	}
	public void setXMSL(double xMSL) {
		XMSL = xMSL;
	}
	public double getXMDJ() {
		return XMDJ;
	}
	public void setXMDJ(double xMDJ) {
		XMDJ = xMDJ;
	}
	public double getXMJE() {
		return XMJE;
	}
	public void setXMJE(double xMJE) {
		XMJE = xMJE;
	}
	public double getXMJSHJ() {
		return XMJSHJ;
	}
	public void setXMJSHJ(double xMJSHJ) {
		XMJSHJ = xMJSHJ;
	}
	public double getSL() {
		return SL;
	}
	public void setSL(double sL) {
		SL = sL;
	}
	public double getSE() {
		return SE;
	}
	public void setSE(double sE) {
		SE = sE;
	}
	public String getHH() {
		return HH;
	}
	public void setHH(String hH) {
		HH = hH;
	}
	public String getZKHHH() {
		return ZKHHH;
	}
	public void setZKHHH(String zKHHH) {
		ZKHHH = zKHHH;
	}
	public String getSPBM() {
		return SPBM;
	}
	public void setSPBM(String sPBM) {
		SPBM = sPBM;
	}
	public String getZXBM() {
		return ZXBM;
	}
	public void setZXBM(String zXBM) {
		ZXBM = zXBM;
	}
	public int getYHZCBS() {
		return YHZCBS;
	}
	public void setYHZCBS(int yHZCBS) {
		YHZCBS = yHZCBS;
	}
	public String getLSBS() {
		return LSBS;
	}
	public void setLSBS(String lSBS) {
		LSBS = lSBS;
	}
	public String getZZSTSGL() {
		return ZZSTSGL;
	}
	public void setZZSTSGL(String zZSTSGL) {
		ZZSTSGL = zZSTSGL;
	}
	public double getKCE() {
		return KCE;
	}
	public void setKCE(double kCE) {
		KCE = kCE;
	}
	
}
