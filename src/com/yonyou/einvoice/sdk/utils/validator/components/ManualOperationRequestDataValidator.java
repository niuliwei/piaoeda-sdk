package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceManualOperationRequestData;

public class ManualOperationRequestDataValidator {
	/**
	  * @author huangshengxin
	  * @date 2017年3月6日 
	*/
	public boolean validate(List<EinvoiceManualOperationRequestData> requestdatas) throws Exception {
		if(requestdatas!=null){
			for (EinvoiceManualOperationRequestData requestdata : requestdatas) {
					if(null==requestdata.getFPQQLSH()){
						throw new Exception("请求流水号不能为空");
					}
					if(null==requestdata.getXSF_NSRSBH()){
						throw new Exception("销售方识别号不能为空");
					}
					if(requestdata.getJSHJ()==0){
						throw new Exception("价税合计不能为0");
					}
			}
		}
		return true;
	}
	
}
