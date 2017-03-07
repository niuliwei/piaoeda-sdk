package com.yonyou.einvoice.sdk.business;

import java.util.Map;

import com.google.gson.Gson;
import com.yonyou.einvoice.sdk.entity.EinvoiceManualOperation;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;
import com.yonyou.einvoice.sdk.utils.Configure;
import com.yonyou.einvoice.sdk.utils.HttpRequestProcessor;
import com.yonyou.einvoice.sdk.utils.ParamBuilder;
import com.yonyou.einvoice.sdk.utils.validator.ManualOperationValidator;

/**
 * @author huangshengxin
 * @date 2017年3月5日
 */
public class ManualOperationBusiness extends BaseBusiness {

	public ManualOperationBusiness() {
		super(Configure.MANUAL_OPERATION_API);
	}

	public EinvoiceRecallResult manualOperate(EinvoiceManualOperation operation) {
		if (new ManualOperationValidator().validate(operation)) {
			Map<String, String> paramMap = new ParamBuilder().buildManualOperationParamMap(operation);
			try {
				String result = HttpRequestProcessor.sendPost(apiURL, paramMap);
				return new Gson().fromJson(result, EinvoiceRecallResult.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
