package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceSMS;

public class SMSValidator {

	
	public boolean validate(List<EinvoiceSMS> smses) throws Exception{
		if(smses==null){
			return true;
		}else{
			for (EinvoiceSMS sms : smses) {
				if(sms.getFpqqlsh()==null){
					throw new Exception("发票请求流水号不能为空！");
				}
				if(sms.getAddress()==null){
					throw new Exception("手机号不能为空！");
				}
				return true;
			}
		}
		return false;
	}
}
