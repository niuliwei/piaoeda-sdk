package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRedRetroRequestdatas;

public class RedRetroRequestDataValidator {
	/**
	  * @author huangshengxin
	  * @date 2017年3月6日 
	*/
	
	public boolean validate(List<EinvoiceRedRetroRequestdatas> requestdatas) throws Exception {
		if(requestdatas!=null){
			for (EinvoiceRedRetroRequestdatas requestdata : requestdatas) {
					if(null==requestdata.getFPQQLSH()){
						throw new Exception("请求流水号不能为空");
					}
					if(null==requestdata.getFpDm()){
						throw new Exception("发票代码不能为空");
					}
					if(requestdata.getFpHm()==null){
						throw new Exception("发票号码不能为空");
					}
			}
		}
		return true;
	}
	
}
