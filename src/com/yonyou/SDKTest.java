package com.yonyou;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import com.yonyou.einvoice.sdk.business.BlueApplyBusiness;
import com.yonyou.einvoice.sdk.business.ProcedureQueryBusiness;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.EinvoiceQueryStatus;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRequestdatasInventory;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceURL;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceBaseResult;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;

/**
 * @author huangshengxin
 * @date 2017年3月2日 
*/
public class SDKTest {
	@Test
	public  void applyTest(){
		List<EinvoiceRequestdatas> requestdatas = new ArrayList<>();
		List<EinvoiceEmail> einvoiceEmails= new ArrayList<>();
		List<EinvoiceSMS> einvoiceSMSs= new ArrayList<>();
		List<EinvoiceURL> einvoiceURLs= new ArrayList<>();
		
		EinvoiceRequestdatas data = new EinvoiceRequestdatas();
		//1q0001344567893
		String fpqqlsh = "1q0001344567912";
		data.setFPQQLSH(fpqqlsh);
		data.setXSF_NSRSBH("201609140000001");
		data.setXSF_MC("用友");
		data.setXSF_DZDH("bshdl10号");
		data.setGMF_MC("用友123");
		data.setJSHJ(100.00);
		
		EinvoiceRequestdatasInventory item1 = new EinvoiceRequestdatasInventory();
		item1.setXMMC("办公用品");
		item1.setXMJSHJ(50.00);
		item1.setSL(0.17);
		item1.setXMSL(1);
		
		EinvoiceRequestdatasInventory item2 = new EinvoiceRequestdatasInventory();
		item2.setXMMC("耗材");
		item2.setXMJSHJ(50.00);
		item2.setSL(0.17);
		item2.setXMSL(2);
		
		List<EinvoiceRequestdatasInventory> list = new ArrayList<>();
		list.add(item1);
		list.add(item2);
		data.setItem(list);
		
		requestdatas.add(data);
		
		
		EinvoiceEmail email  = new EinvoiceEmail();
		email.setFpqqlsh(fpqqlsh);
		email.setAddress("huangshengxin@yonyou.com");
		
		EinvoiceSMS sms = new EinvoiceSMS();
		sms.setFpqqlsh(fpqqlsh);
		sms.setAddress("15201242530");
		
		EinvoiceURL url = new EinvoiceURL();
		url.setFpqqlsh(fpqqlsh);
		url.setUrl("www.baidu.com");
		
		einvoiceEmails.add(email);
		einvoiceSMSs.add(sms);
		einvoiceURLs.add(url);
		EinvoiceBlueApply apply = new EinvoiceBlueApply();
		apply.setRequestdatas(requestdatas);
		apply.setEmail(einvoiceEmails);
		apply.setSms(einvoiceSMSs);
		apply.setUrl(einvoiceURLs);
		apply.setAutoAudit(true);
		
		//apply.setAutoAudit(false);
		
		//1.开票测试
		BlueApplyBusiness blueApplyBusiness = new BlueApplyBusiness();
		EinvoiceBaseResult baseResult = blueApplyBusiness.apply(apply);
		System.out.println(baseResult);
		
		//2.查询测试
//		ProcedureQueryBusiness queryBusiness = new ProcedureQueryBusiness();
//		EinvoiceQueryStatus queryStatus = new EinvoiceQueryStatus();
//		queryStatus.setFpqqlsh(fpqqlsh);
//		EinvoiceRecallResult queryResult = queryBusiness.query(queryStatus);
//		System.out.println(queryResult);
		
	}
}
