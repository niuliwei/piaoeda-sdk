package com.yonyou.einvoice.sdk;

import com.yonyou.einvoice.sdk.business.BlueApplyBusiness;
import com.yonyou.einvoice.sdk.business.ManualOperationBusiness;
import com.yonyou.einvoice.sdk.business.ProcedureQueryBusiness;
import com.yonyou.einvoice.sdk.business.RedRetrogradationBusiness;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.EinvoiceManualOperation;
import com.yonyou.einvoice.sdk.entity.EinvoiceQueryStatus;
import com.yonyou.einvoice.sdk.entity.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceBaseResult;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;
import com.yonyou.einvoice.sdk.utils.Configure;

/**
 * @author huangshengxin
 * @date 2017年3月7日 
*/
public class EinvoiceSDk {
	/**
	 * 
	 * @param einvoiceBlueApply
	 * @return
	 * EinvoiceRecallResult
	 * 蓝票开票申请
	 */
	public EinvoiceSDk(){
		Configure.init();
	}
	
	public  EinvoiceRecallResult apply(EinvoiceBlueApply einvoiceBlueApply) {
		return new BlueApplyBusiness().apply(einvoiceBlueApply);
	}
	/**
	 * 
	 * @param einvoiceQueryStatus
	 * @return
	 * EinvoiceRecallResult
	 * 开票状态查询
	 */
	public  EinvoiceRecallResult query(EinvoiceQueryStatus einvoiceQueryStatus) {
		return new ProcedureQueryBusiness().query(einvoiceQueryStatus);
	}
	/**
	 * 
	 * @param einvoiceRedRetro
	 * @return
	 * EinvoiceRecallResult
	 * 发票冲红
	 */
	public  EinvoiceRecallResult retrograd(EinvoiceRedRetro einvoiceRedRetro) {
		return new RedRetrogradationBusiness().retrograd(einvoiceRedRetro);
	}
	/**
	 * 
	 * @param einvoiceManualOperation
	 * @return
	 * EinvoiceRecallResult
	 * 人工审核开票
	 */
	public  EinvoiceBaseResult manualOperate(EinvoiceManualOperation einvoiceManualOperation) {
		return new ManualOperationBusiness().manualOperate(einvoiceManualOperation);
	}
}
