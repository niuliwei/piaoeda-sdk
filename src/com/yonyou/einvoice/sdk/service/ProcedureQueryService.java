package com.yonyou.einvoice.sdk.service;

import com.yonyou.einvoice.sdk.utils.Configure;
/**
 * @author huangshengxin
 * @date 2017年3月3日 
*/

import net.sf.json.JSONObject;
public class ProcedureQueryService extends BaseService {

	public ProcedureQueryService()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.PROCEDURE_STATUS_QUERY_API);
	}

	public String procedureStatusQuery(String fpqqlsh) throws Exception{
		return this.sendGet(fpqqlsh);
	}
	
/*	private JSONObject sendGet(String fpqqlsh){
		return 
	}*/

}
