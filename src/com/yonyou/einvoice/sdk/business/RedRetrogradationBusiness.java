package com.yonyou.einvoice.sdk.business;

import java.util.Map;

import com.google.gson.Gson;
import com.yonyou.einvoice.sdk.entity.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;
import com.yonyou.einvoice.sdk.utils.Configure;
import com.yonyou.einvoice.sdk.utils.HttpRequestProcessor;
import com.yonyou.einvoice.sdk.utils.ParamBuilder;
import com.yonyou.einvoice.sdk.utils.validator.RedRetroValidator;

/**
 * @author huangshengxin
 * @date 2017年3月3日 红字冲回
 */

public class RedRetrogradationBusiness extends BaseBusiness {

	public RedRetrogradationBusiness() {
		super(Configure.RED_INVOICE_RETROGRADATION);
	}

	public EinvoiceRecallResult retrograd(EinvoiceRedRetro einvoiceRedRetro) {
		if (new RedRetroValidator().validate(einvoiceRedRetro)) {
			Map<String, String> paramMap = new ParamBuilder().buildRedRetroParamMap(einvoiceRedRetro);
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
