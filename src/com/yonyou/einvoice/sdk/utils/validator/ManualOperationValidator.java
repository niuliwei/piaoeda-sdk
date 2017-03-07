package com.yonyou.einvoice.sdk.utils.validator;

import com.yonyou.einvoice.sdk.entity.EinvoiceManualOperation;
import com.yonyou.einvoice.sdk.utils.validator.components.ManualOperationRequestDataValidator;

public class ManualOperationValidator {
	/**
	  * @author huangshengxin
	  * @date 2017年3月6日 
	*/
	
	public boolean validate(EinvoiceManualOperation einvoiceManualOperation){
		try {
			new ManualOperationRequestDataValidator().validate(einvoiceManualOperation.getEinvoiceManualOperationRequestData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
