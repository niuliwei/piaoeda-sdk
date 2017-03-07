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
import com.yonyou.einvoice.sdk.entity.results.EinvoiceQueryResult;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;

/**
 * @author huangshengxin
 * @date 2017年3月7日 
*/
public class EinvoiceSDkUtil {
	/**
	 * 
	 * @param einvoiceBlueApply
	 * @return
	 * EinvoiceRecallResult
	 * 蓝票开票申请
	 */
	public static EinvoiceRecallResult apply(EinvoiceBlueApply einvoiceBlueApply) {
		return new BlueApplyBusiness().apply(einvoiceBlueApply);
	}
	/**
	 * 
	 * @param einvoiceQueryStatus
	 * @return
	 * EinvoiceRecallResult
	 * 开票状态查询
	 */
	public static EinvoiceRecallResult query(EinvoiceQueryStatus einvoiceQueryStatus) {
		return new ProcedureQueryBusiness().query(einvoiceQueryStatus);
	}
	/**
	 * 
	 * @param einvoiceRedRetro
	 * @return
	 * EinvoiceRecallResult
	 * 发票冲红
	 */
	public static EinvoiceRecallResult retrograd(EinvoiceRedRetro einvoiceRedRetro) {
		return new RedRetrogradationBusiness().retrograd(einvoiceRedRetro);
	}
	/**
	 * 
	 * @param einvoiceManualOperation
	 * @return
	 * EinvoiceRecallResult
	 * 人工审核开票
	 */
	public static EinvoiceBaseResult manualOperate(EinvoiceManualOperation einvoiceManualOperation) {
		return new ManualOperationBusiness().manualOperate(einvoiceManualOperation);
	}
}
