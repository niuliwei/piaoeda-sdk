package com.yonyou.einvoice.sdk.entity;

/**
 * @author huangshengxin
 * @date 2017年3月1日 
 * 开票申请发票信息
 */
public class EinvoiceRequestdatas extends EinvoiceObject {

	private static final long serialVersionUID = -6578887158470453709L;
	/**
	 * 发票头
	 */
	private EinvoiceRequestdatasHeader einvoiceRequestdatasHeader;
	/**
	 * 发票明细
	 */
	private EinvoiceRequestdatasInventory einvoiceRequestdatasInventory;
	public EinvoiceRequestdatasHeader getEinvoiceRequestdatasHeader() {
		return einvoiceRequestdatasHeader;
	}
	public void setEinvoiceRequestdatasHeader(EinvoiceRequestdatasHeader einvoiceRequestdatasHeader) {
		this.einvoiceRequestdatasHeader = einvoiceRequestdatasHeader;
	}
	public EinvoiceRequestdatasInventory getEinvoiceRequestdatasInventory() {
		return einvoiceRequestdatasInventory;
	}
	public void setEinvoiceRequestdatasInventory(EinvoiceRequestdatasInventory einvoiceRequestdatasInventory) {
		this.einvoiceRequestdatasInventory = einvoiceRequestdatasInventory;
	}
	
	
}
