package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;

/**
 * @author huangshengxin
 * @date 2017年3月6日 
*/
public class EmailValidator {
	
	public boolean validate(List<EinvoiceEmail> emails) throws Exception{
		if(emails==null){
			return true;
		}else{
			for (EinvoiceEmail email : emails) {
				if(email.getFpqqlsh()==null){
					throw new Exception("发票请求流水号不能为空！");
				}
				if(email.getAddress()==null){
					throw new Exception("邮箱不能为空！");
				}
				return true;
			}
		}
		return false;
		
	}
}
