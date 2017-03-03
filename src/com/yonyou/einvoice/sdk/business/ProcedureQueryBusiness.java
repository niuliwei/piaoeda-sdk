package com.yonyou.einvoice.sdk.business;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.yonyou.einvoice.sdk.service.ProcedureQueryService;

/**
 * @author huangshengxin
 * @date 2017年3月3日 
 * 查询开票状态
 */
public class ProcedureQueryBusiness {
	
	private ProcedureQueryService procedureQueryService;
	
	public ProcedureQueryBusiness(){
		try {
			this.procedureQueryService = new ProcedureQueryService();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	
	public String procedureStatusQuery(String fpqqlsh){
		try {
			return procedureQueryService.procedureStatusQuery(fpqqlsh).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

