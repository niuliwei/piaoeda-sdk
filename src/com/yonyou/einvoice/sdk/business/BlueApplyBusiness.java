package com.yonyou.einvoice.sdk.business;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.service.BlueInvoiceService;


/**
 * @author huangshengxin
 * @date 2017年3月2日 
 * 开蓝票申请
 */
public class BlueApplyBusiness {
	
	//private static String result = "";
	private BlueInvoiceService blueInvoiceService;
	
	public BlueApplyBusiness(){
		try {
			this.blueInvoiceService = new BlueInvoiceService();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	public String applyBlueInvoice(EinvoiceBlueApply einvoiceBlueApply) {
		try {
			return blueInvoiceService.applyBlueinvoice(einvoiceBlueApply).toString();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
