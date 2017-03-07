package com.yonyou.einvoice.sdk.entity;

/**
 * @author huangshengxin
 * @date 2017年3月4日 
 * 查询开票状态
 */
public class EinvoiceQueryStatus extends EinvoiceObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6803459112345788287L;
	
	/**
	 * 发票请求流水号
	 */
	private String fpqqlsh;

	public String getFpqqlsh() {
		return fpqqlsh;
	}

	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}
}
