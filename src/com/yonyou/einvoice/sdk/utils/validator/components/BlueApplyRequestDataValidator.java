package com.yonyou.einvoice.sdk.utils.validator.components;

import java.util.List;

import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatasInventory;
/**
 * @author huangshengxin
 * @date 2017年3月6日 
*/
public class BlueApplyRequestDataValidator {

	
	public boolean validate(List<EinvoiceRequestdatas> requestdatas) throws Exception {
		if(requestdatas!=null){
			for (EinvoiceRequestdatas requestdata : requestdatas) {
					if(null==requestdata.getFPQQLSH()){
						throw new Exception("请求流水号不能为空");
					}
					if(null==requestdata.getXSF_NSRSBH()){
						throw new Exception("销售方识别号不能为空");
					}
					if(requestdata.getGMF_MC()==null){
						throw new Exception("购买方名称不能为空");
					}
					if(0==requestdata.getJSHJ()){
						throw new Exception("价税合计不能为0");
					}
					List<EinvoiceRequestdatasInventory> items = requestdata.getItem();
					if(items==null){
						throw new Exception("明细清单不能为空");
					}
					double itemTotal = 0;
					for (EinvoiceRequestdatasInventory item : items) {
						
						if(null==item.getXMMC()){
							throw new Exception("项目名称不能为空");
						}
						if(0==item.getXMSL()){
							throw new Exception("项目数量不能为0");
						}
						if(0==item.getXMJSHJ()){
							throw new Exception("项目计税合计不能为0");
						}
						if(0==item.getSL()){
							throw new Exception("请选择正确税率");
						}
						itemTotal = itemTotal + item.getXMJSHJ();
					}
					if (itemTotal!=requestdata.getJSHJ()) {
						throw new Exception("明细合计数不等于价税合计！");
					}
			}
		}
		return true;
	}
	
}
