package com.yonyou;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.RowSetMetaDataImpl;

import org.junit.Test;

import com.google.gson.Gson;
import com.yonyou.einvoice.sdk.business.BlueApplyBusiness;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.EinvoiceRequestdatas;
import com.yonyou.einvoice.sdk.entity.EinvoiceRequestdatasInventory;
import com.yonyou.einvoice.sdk.entity.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.EinvoiceURL;
import com.yonyou.einvoice.sdk.utils.MapBuilder;

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
		data.setFPQQLSH("1q0001234567890");
		data.setXSF_NSRSBH("201609140000001");
		data.setXSF_MC("cabr");
		data.setXSF_DZDH("bshdl10号");
		data.setGMF_MC("用友");
		data.setJSHJ(100.00);
		
		EinvoiceRequestdatasInventory item1 = new EinvoiceRequestdatasInventory();
		item1.setXMMC("办公用品");
		item1.setXMJSHJ(50.00);
		item1.setSL(0.17);
		
		EinvoiceRequestdatasInventory item2 = new EinvoiceRequestdatasInventory();
		item2.setXMMC("耗材");
		item2.setXMJSHJ(50.00);
		item2.setSL(0.17);
		
		List<EinvoiceRequestdatasInventory> list = new ArrayList<>();
		list.add(item1);
		list.add(item2);
		data.setItem(list);
		
		requestdatas.add(data);
		
		
//		EinvoiceEmail email  = new EinvoiceEmail();
//		email.setFpqqlsh("1234567890");
//		email.setAddress("hsx@yonyou.com");
//		
//		EinvoiceSMS sms = new EinvoiceSMS();
//		sms.setFpqqlsh("1234567890");
//		sms.setAddress("12888888888");
//		
//		EinvoiceURL url = new EinvoiceURL();
//		url.setFpqqlsh("1234567890");
//		url.setUrl("www.bilibili.com");
//		
//		einvoiceEmails.add(email);
//		einvoiceSMSs.add(sms);
//		einvoiceURLs.add(url);
//		
		EinvoiceBlueApply apply = new EinvoiceBlueApply();
		apply.setRequestdatas(requestdatas);
		apply.setEmail(einvoiceEmails);
		apply.setSms(einvoiceSMSs);
		apply.setUrl(einvoiceURLs);
		apply.setAutoAudit(true);
		
		//MapBuilder.buildPostParam(apply).toString();
		System.out.println();
		//Gson gson = new Gson();
		//System.out.println(gson.toJson(apply));
		//apply.setAutoAudit(true);
		BlueApplyBusiness blueApplyBusiness = new BlueApplyBusiness();
		
		System.out.println(blueApplyBusiness.applyBlueInvoice(apply));
		//Gson gson = new Gson();
		//String json = "[ {\"FPQQLSH\" : \"12345678901234567890\",    \"XSF_NSRSBH\" : \"销售方纳税人识别号\",    \"XSF_MC\" : \"销售方名称\",    \"XSF_DZDH\" : \"销售方地址、电话\",    \"XSF_YHZH\" : \"销售方银行账号\",    \"GMF_NSRSBH\" : \"购买方纳税人识别号\",    \"GMF_MC\" : \"购买方名称\",    \"GMF_DZDH\" : \"购买方地址、电话\",    \"GMF_YHZH\" : \"购买方银行账号\",    \"KPR\" : \"开票人\",    \"SKR\" : \"收款人\",    \"FHR\" : \"复核人\",    \"JSHJ\" : \"价税合计\",    \"HJJE\" : \"合计金额\",    \"HJSE\" : \"合计税额\",    \"BZ\" : \"备注\",    \"BMB_BBH\" : \"10.0\",    \"items\" : [{            \"FPHXZ\" : \"发票行性质\",            \"XMMC\" : \"项目名称\",            \"GGXH\" : \"规格型号\",            \"DW\" : \"单位\",            \"XMSL\" : \"项目数量\",            \"XMDJ\" : \"项目单价\",            \"XMJE\" : \"项目金额\",            \"XMJSHJ\" : \"项目价税合计\",            \"SL\" : \"税率\",            \"SE\" : \"税额\",            \"HH\":\"行号\",            \"SPBM\":\"商品编码\",  \"ZXBM\":\"自行编码\"  \"KCE\":300  }    ]}]";
		//EinvoiceRequestdatas fromJson = gson.fromJson(json, EinvoiceRequestdatas.class);
		//System.out.println(fromJson.toString());
		/*EinvoiceRequestdatas data = new EinvoiceRequestdatas();
		data.setFPQQLSH("1234567890");
		data.setXSF_NSRSBH("110105400001141");
		data.set*/
		
		//EinvoiceBlueApply apply = new EinvoiceBlueApply();
		/*apply.setRequestdatas();
		apply.setEmail();
		apply.setSms();
		apply.setUrl();*/
		//apply.setAutoAudit(true);
		//return null;
		
	}
}
