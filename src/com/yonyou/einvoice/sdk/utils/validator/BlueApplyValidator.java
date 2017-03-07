package com.yonyou.einvoice.sdk.utils.validator;

import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.utils.validator.components.BlueApplyRequestDataValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.EmailValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.SMSValidator;
import com.yonyou.einvoice.sdk.utils.validator.components.URLValidator;

/**
 * @author huangshengxin
 * @date 2017年3月6日 
*/
public class BlueApplyValidator {
	public boolean validate(EinvoiceBlueApply einvoiceBlueApply){
		try {
			new BlueApplyRequestDataValidator().validate(einvoiceBlueApply.getRequestdatas());
			new EmailValidator().validate(einvoiceBlueApply.getEmail());
			new SMSValidator().validate(einvoiceBlueApply.getSms());
			new URLValidator().validate(einvoiceBlueApply.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
