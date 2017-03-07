package com.yonyou.einvoice.sdk.utils.validator;

import com.yonyou.einvoice.sdk.entity.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.utils.validator.components.EmailValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.RedRetroRequestDataValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.SMSValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.URLValidator;

public class RedRetroValidator {
	/**
	  * @author huangshengxin
	  * @date 2017年3月6日 
	*/
	
	public boolean validate(EinvoiceRedRetro einvoiceRedRetro){
		try {
			new RedRetroRequestDataValidator().validate(einvoiceRedRetro.getRequestdatas());
			new EmailValidator().validate(einvoiceRedRetro.getEmail());
			new SMSValidator().validate(einvoiceRedRetro.getSms());
			new URLValidator().validate(einvoiceRedRetro.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
