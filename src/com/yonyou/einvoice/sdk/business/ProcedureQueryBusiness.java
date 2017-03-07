package com.yonyou.einvoice.sdk.business;

import java.util.Map;

import com.google.gson.Gson;
import com.yonyou.einvoice.sdk.entity.EinvoiceQueryStatus;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;
import com.yonyou.einvoice.sdk.utils.Configure;
import com.yonyou.einvoice.sdk.utils.HttpRequestProcessor;
import com.yonyou.einvoice.sdk.utils.ParamBuilder;

/**
 * @author huangshengxin
 * @date 2017年3月3日 查询开票状态
 */
public class ProcedureQueryBusiness extends BaseBusiness {

	public ProcedureQueryBusiness() {
		super(Configure.PROCEDURE_STATUS_QUERY_API);
	}

	public EinvoiceRecallResult query(EinvoiceQueryStatus einvoiceQueryStatus) {

		Map<String, String> paramsMap = new ParamBuilder().buildStatusQueryParam(einvoiceQueryStatus);
		try {
			String result = HttpRequestProcessor.sendPost(apiURL, paramsMap);
			return new Gson().fromJson(result, EinvoiceRecallResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
