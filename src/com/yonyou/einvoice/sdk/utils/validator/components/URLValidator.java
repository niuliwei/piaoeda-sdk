package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceURL;

/**
 * @author huangshengxin
 * @date 2017年3月6日 
*/
public class URLValidator {
	
	public boolean validate(List<EinvoiceURL> urls) throws Exception{
		if(urls==null){
			return true;
		}else{
			for (EinvoiceURL url : urls) {
				if(url.getFpqqlsh()==null){
					throw new Exception("发票请求流水号不能为空！");
				}
				if(url.getUrl()==null){
					throw new Exception("回调地址不能为空！");
				}
				return true;
			}
		}
		return false;
		
	}
}
