package com.yonyou;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yonyou.einvoice.sdk.business.RedRetrogradationBusiness;
import com.yonyou.einvoice.sdk.entity.EinvoiceRedRetro;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceRedRetroRequestdatas;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceURL;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceBaseResult;
import com.yonyou.einvoice.sdk.entity.results.EinvoiceRecallResult;

/**
 * @author huangshengxin
 * @date 2017年3月4日 
*/
public class RedRetroTest {
	 
	@Test
	public void redTest(){
		
		List<EinvoiceRedRetroRequestdatas> requestdatas = new ArrayList<>();
		List<EinvoiceEmail> einvoiceEmails= new ArrayList<>();
		List<EinvoiceSMS> einvoiceSMSs= new ArrayList<>();
		List<EinvoiceURL> einvoiceURLs= new ArrayList<>();
		
		EinvoiceRedRetroRequestdatas data = new EinvoiceRedRetroRequestdatas();
		//1q0001344567893
		String fpqqlsh = "1q0001344567913";
		data.setFPQQLSH(fpqqlsh);
		data.setFpDm("010011652011");
		data.setFpHm("68457353");
		data.setORGCODE("");
		
//		EinvoiceRequestdatasInventory item1 = new EinvoiceRequestdatasInventory();
//		item1.setXMMC("办公用品");
//		item1.setXMJSHJ(50.00);
//		item1.setSL(0.17);
//		
//		EinvoiceRequestdatasInventory item2 = new EinvoiceRequestdatasInventory();
//		item2.setXMMC("耗材");
//		item2.setXMJSHJ(50.00);
//		item2.setSL(0.17);
//		
//		List<EinvoiceRequestdatasInventory> list = new ArrayList<>();
//		list.add(item1);
//		list.add(item2);
//		data.setItem(list);
		
		requestdatas.add(data);
		
		
		EinvoiceEmail email  = new EinvoiceEmail();
		email.setFpqqlsh(fpqqlsh);
		email.setAddress("huangshengxin@yonyou.com");
		
		EinvoiceSMS sms = new EinvoiceSMS();
		sms.setFpqqlsh(fpqqlsh);
		sms.setAddress("15201242530");
		
		EinvoiceURL url = new EinvoiceURL();
		url.setFpqqlsh(fpqqlsh);
		url.setUrl("www.bilibili.com");
		
		einvoiceEmails.add(email);
		einvoiceSMSs.add(sms);
		einvoiceURLs.add(url);
		
		EinvoiceRedRetro retro = new EinvoiceRedRetro();
		
		retro.setEmail(einvoiceEmails);
		retro.setRequestdatas(requestdatas);
		retro.setSms(einvoiceSMSs);
		retro.setUrl(einvoiceURLs);
		retro.setAutoAudit(true);
		RedRetrogradationBusiness redRetrogradationBusiness = new RedRetrogradationBusiness();
		EinvoiceRecallResult baseResult = redRetrogradationBusiness.retrograd(retro);
		System.out.println(baseResult);
	}
}
