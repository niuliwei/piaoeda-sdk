package com.yonyou.einvoice.sdk.business;

import java.util.Map;

import com.google.gson.Gson;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;
import com.yonyou.einvoice.sdk.utils.Configure;
import com.yonyou.einvoice.sdk.utils.HttpRequestProcessor;
import com.yonyou.einvoice.sdk.utils.ParamBuilder;
import com.yonyou.einvoice.sdk.utils.validator.BlueApplyValidator;

/**
 * @author huangshengxin
 * @date 2017年3月2日 开蓝票申请
 */
public class BlueApplyBusiness extends BaseBusiness {

	public BlueApplyBusiness() {
		super(Configure.APPLY_BLUE_INVOICE_API);
	}

	public EinvoiceRecallResult apply(EinvoiceBlueApply einvoiceBlueApply) {

		if (new BlueApplyValidator().validate(einvoiceBlueApply)) {

			Map<String, String> paramMap = new ParamBuilder().buildAllpyParamMap(einvoiceBlueApply);
			String result;
			try {
				result = HttpRequestProcessor.sendPost(apiURL, paramMap);
				return new Gson().fromJson(result, EinvoiceRecallResult.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
