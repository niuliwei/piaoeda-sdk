package com.yonyou.einvoice.sdk.business;

import com.yonyou.einvoice.sdk.service.RedRetrogradationService;

/**
 * @author huangshengxin
 * @date 2017年3月3日 
 * 红字冲回
 */
public class RedRetrogradationBusiness {
	 
	private RedRetrogradationService redRetrogradationService;
	
	
	public  RedRetrogradationBusiness(){
		try {
			this.redRetrogradationService = new RedRetrogradationService();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	public String redRetrograd(EinvoiceRedRetro einvoiceRedRetro){
		
		try {
			return redRetrogradationService.redRetrograd(einvoiceRedRetro).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
