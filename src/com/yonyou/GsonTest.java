package com.yonyou;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yonyou.einvoice.sdk.entity.conponents.EinvoiceEmail;

public class GsonTest {
	/**
	  * @author huangshengxin
	  * @date 2017年3月2日 
	*/
	@Test
	public void fromTest(){
		Gson gson = new Gson();
		String json = "[{\"fpqqlsh\":\"12345678901234567890\",\"address\": \"x1@yonyou.com,x2@yonyou.com\", \"title\": \"电子发票\", \"content\": \"订单XXX电子发票。\"}, {\"fpqqlsh\":\"12345678901234567890\",\"address\": \"x3@yonyou.com\", \"title\": \"电子发票\", \"content\": \"订单XXX电子发票。\"}]";
		List<EinvoiceEmail> list = gson.fromJson(json, new TypeToken<List<EinvoiceEmail>>() {
        }.getType());
		for (EinvoiceEmail email:list){
			System.out.println(email.toString());
        }
	}
}
