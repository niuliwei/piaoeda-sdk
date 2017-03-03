package com.yonyou.einvoice.sdk.service;

import com.yonyou.einvoice.sdk.business.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.utils.Configure;

import net.sf.json.JSONObject;

/**
  * @author huangshengxin
  * @date 2017年3月3日 
*/
public class RedRetrogradationService extends BaseService {

	public RedRetrogradationService()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.RED_INVOICE_RETROGRADATION);
		
	}
	

	public String redRetrograd(EinvoiceRedRetro einvoiceRedRetro) throws Exception {
		return this.sendPost(einvoiceRedRetro);
		
	}
}