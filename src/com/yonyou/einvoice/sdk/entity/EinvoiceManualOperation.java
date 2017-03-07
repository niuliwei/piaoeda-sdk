package com.yonyou.einvoice.sdk.entity;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceManualOperationRequestData;

/**
 * @author huangshengxin
 * @date 2017年3月5日 开票申请开票
 */
public class EinvoiceManualOperation extends EinvoiceObject {

	private static final long serialVersionUID = 362197928460376699L;

	/**
	 * 开票申请开票
	 */
	private List<EinvoiceManualOperationRequestData> einvoiceManualOperationRequestData;

	/*public EinvoiceManualOperation(EinvoiceBlueApply einvoiceBlueApply) {
		List<EinvoiceRequestdatas> requestdatas = einvoiceBlueApply.getRequestdatas();

		for (EinvoiceRequestdatas data : requestdatas) {
			this.einvoiceManualOperationRequestData.add(
					new EinvoiceManualOperationRequestData(data.getFPQQLSH(), data.getXSF_NSRSBH(), data.getJSHJ()));
		}
		
	}*/

	public List<EinvoiceManualOperationRequestData> getEinvoiceManualOperationRequestData() {
		return einvoiceManualOperationRequestData;
	}

	public void setEinvoiceManualOperationRequestData(
			List<EinvoiceManualOperationRequestData> einvoiceManualOperationRequestData) {
		this.einvoiceManualOperationRequestData = einvoiceManualOperationRequestData;
	}
}
