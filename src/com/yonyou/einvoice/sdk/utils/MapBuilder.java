package com.yonyou.einvoice.sdk.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.util.io.pem.PemReader;

import com.google.gson.GsonBuilder;
import com.yonyou.einvoice.sdk.entity.EinvoiceBlueApply;
import com.yonyou.einvoice.sdk.entity.EinvoiceEmail;
import com.yonyou.einvoice.sdk.entity.EinvoiceRequestdatas;
import com.yonyou.einvoice.sdk.entity.EinvoiceRequestdatasInventory;
import com.yonyou.einvoice.sdk.entity.EinvoiceSMS;
import com.yonyou.einvoice.sdk.entity.EinvoiceURL;
import com.yonyou.einvoice.test.JwtParamBuilder;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

/**
 * @author administrator
 * @date 2017年3月2日 
*/
public class MapBuilder {
	
	
	
	public static String sign(Map<String, String> paramsMap) throws Exception {

	    // 读取CA证书与PEM格式证书需要根据实际证书使用情况而定,目前这两种都支持
	     PrivateKey privateKey = loadPrivateKeyOfCA();
	    //PrivateKey privateKey = loadPrivateKeyOfPem();

	    Map<String, Object> claims =
	        JwtParamBuilder.build().setSubject("tester").setIssuer("einvoice").setAudience("einvoice")
	            .addJwtId().addIssuedAt().setExpirySeconds(300).setNotBeforeSeconds(300).getClaims();

	    // 需要将表单参数requestdatas的数据进行md5加密，然后放到签名数据的requestdatas中。
	    // 此签名数据必须存在，否则在验证签名时会不通过。
	    String value = paramsMap.get("requestdatas");
	    claims.put("requestdatas", getMD5(value));

	    // 使用jdk1.6版本时，删除下面代码的中.compressWith(CompressionCodecs.DEFLATE)
	    String compactJws = Jwts.builder().signWith(SignatureAlgorithm.RS512, privateKey)
	        .setClaims(claims).compressWith(CompressionCodecs.DEFLATE).compact();

	    return compactJws;
	  }

	/**
	   * 计算MD5
	   * 
	   * @param str
	   * @return
	   * @throws UnsupportedEncodingException
	   * @throws NoSuchAlgorithmException
	   */
	  private static String getMD5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	    byte[] buf = null;
	    buf = str.getBytes("utf-8");
	    MessageDigest md5 = null;
	    md5 = MessageDigest.getInstance("MD5");
	    md5.update(buf);
	    byte[] tmp = md5.digest();
	    StringBuilder sb = new StringBuilder();
	    for (byte b : tmp) {
	      sb.append(String.format("%02x", b & 0xff));
	    }
	    return sb.toString();
	  }

	  /**
	   * 读取PEM编码格式
	   * 
	   * @return
	   * @throws IOException
	   * @throws NoSuchAlgorithmException
	   * @throws InvalidKeySpecException
	   */
	  protected static PrivateKey loadPrivateKeyOfPem()
	      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
	    PemReader reader = new PemReader(new FileReader("D:\\00work\\00workspace\\piaoeda-SDK\\source\\pro22.pfx"));
	    byte[] privateKeyBytes = reader.readPemObject().getContent();
	    reader.close();
	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
	    KeyFactory kf = KeyFactory.getInstance("RSA");
	    PrivateKey privateKey = kf.generatePrivate(spec);
	    return privateKey;
	  }

	  /**
	   * 读取证书私钥
	   * 
	   * @return
	   * @throws UnrecoverableKeyException
	   * @throws KeyStoreException
	   * @throws NoSuchAlgorithmException
	   * @throws CertificateException
	   * @throws IOException
	   */
	  protected static PrivateKey loadPrivateKeyOfCA() throws UnrecoverableKeyException, KeyStoreException,
	      NoSuchAlgorithmException, CertificateException, IOException {
	    String keypath = "D:\\00work\\00workspace\\piaoeda-SDK\\source\\pro22.pfx";
	    FileInputStream in = new FileInputStream(keypath);
	    KeyStore ks = KeyStore.getInstance("pkcs12");
	    String pwd = "password";
	    ks.load(in, pwd.toCharArray());
	    String alias = ks.aliases().nextElement();
	    PrivateKey caprk = (PrivateKey) ks.getKey(alias, pwd.toCharArray());
	    return caprk;
	  }
	
	public static  Map<String, String> buildPostParam(Object object) {
		EinvoiceBlueApply einvoiceBlueApply = (EinvoiceBlueApply) object;
		Map<String, String> paramsMap = new HashMap<String, String>();
	    paramsMap.put("requestdatas", buildRequestDatas(einvoiceBlueApply));
//	    paramsMap.put("email", buildEmailConfigs(einvoiceBlueApply));
//	    paramsMap.put("sms", buildSmsConfigs(einvoiceBlueApply));
//	    paramsMap.put("url", buildUrlConfigs(einvoiceBlueApply));
  paramsMap.put("autoAudit", "true");

	    return paramsMap;
	  }

	  /**
	   * url回掉配置
	 * @param einvoiceBlueApply 
	   * 
	   * @return
	   */
	  private static String buildUrlConfigs(EinvoiceBlueApply einvoiceBlueApply) {
		  
		  List<EinvoiceURL> urls = einvoiceBlueApply.getUrl();
			 List<Map<String, Object>> datas = new ArrayList<>();
			 for (EinvoiceURL url : urls) {
				Map<String, Object> map = new HashMap<>();
				map.put("fpqqlsh", url.getFpqqlsh());
				map.put("url", url.getUrl());
				datas.add(map);
			}
			 
			 GsonBuilder builder = new GsonBuilder();
			 	return builder.create().toJson(datas);
	  }

	  /**
	   * 构造短信发送信息
	 * @param einvoiceBlueApply 
	   * 
	   * @return
	   */
	  private static String buildSmsConfigs(EinvoiceBlueApply einvoiceBlueApply) {
		  List<EinvoiceSMS> smses = einvoiceBlueApply.getSms();
			 List<Map<String, Object>> datas = new ArrayList<>();
			 for (EinvoiceSMS sms : smses) {
				Map<String, Object> map = new HashMap<>();
				map.put("fpqqlsh", sms.getFpqqlsh());
				map.put("address", sms.getAddress());
				map.put("title", sms.getTitle());
				map.put("content", sms.getContent());
				datas.add(map);
			}
			 
			 GsonBuilder builder = new GsonBuilder();
			 	return builder.create().toJson(datas);
	  }

	  /**
	   * 构造email发送信息
	   * 
	   * @return
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	   */
	  private static String buildEmailConfigs(EinvoiceBlueApply einvoiceBlueApply){
		 
			 List<EinvoiceEmail> emails = einvoiceBlueApply.getEmail();
			 List<Map<String, Object>> datas = new ArrayList<>();
			 for (EinvoiceEmail email : emails) {
				Map<String, Object> map = new HashMap<>();
				map.put("fpqqlsh", email.getFpqqlsh());
				map.put("address", email.getAddress());
				map.put("title", email.getTitle());
				map.put("content", email.getContent());
				datas.add(map);
			}
			 
			 GsonBuilder builder = new GsonBuilder();
			 	return builder.create().toJson(datas);
			 
		 }


	/**
	   * 构造requestdatas
	 * @param einvoiceBlueApply 
	   * 
	   * @return
	   */
	  private static String buildRequestDatas(EinvoiceBlueApply einvoiceBlueApply) {
		  
		  List<EinvoiceRequestdatas> einvoiceRequestdatas = einvoiceBlueApply.getRequestdatas();
			 List<Map<String, Object>> datas = new ArrayList<>();
			 for (EinvoiceRequestdatas requestdata : einvoiceRequestdatas) {
				Map<String, Object> map = new HashMap<>();
				map.put("FPQQLSH", requestdata.getFPQQLSH());
				map.put("XSF_NSRSBH", requestdata.getXSF_NSRSBH());
				map.put("XSF_MC", requestdata.getXSF_MC());
				map.put("XSF_DZDH", requestdata.getXSF_DZDH());
//				map.put("XSF_YHZH", requestdata.getXSF_YHZH());
//				map.put("GMF_NSRSBH", requestdata.getGMF_NSRSBH());
				map.put("GMF_MC", requestdata.getGMF_MC());
//				map.put("GMF_DZDH", requestdata.getGMF_DZDH());
//				map.put("GMF_YHZH", requestdata.getGMF_YHZH());
//				map.put("KPR", requestdata.getKPR());
//				map.put("SKR", requestdata.getSKR());
//				map.put("FHR", requestdata.getFHR());
				map.put("JSHJ", requestdata.getJSHJ());
//				map.put("HJJE", requestdata.getHJJE());
//				map.put("HJSE", requestdata.getHJSE());
				//map.put("BZ", requestdata.getBZ());
//				map.put("BMB_BBH", requestdata.getBMB_BBH());
//				map.put("BZ", requestdata.getBZ());
				map.put("items", buildItems(requestdata.getItem()));
				datas.add(map);
			}
			 
			 GsonBuilder builder = new GsonBuilder();
			 	return builder.create().toJson(datas);
	  }

	  /**
	   * 构造request发票明细
	 * @param list 
	   * 
	   * @return
	   */
	  private static List<Map<String, Object>> buildItems(List<EinvoiceRequestdatasInventory> inventories) {
		  	
			 List<Map<String, Object>> datas = new ArrayList<>();
			 for (EinvoiceRequestdatasInventory inventory : inventories) {
				Map<String, Object> map = new HashMap<>();
//				map.put("FPHXZ",inventory.getFPHXZ());
				map.put("XMMC",inventory.getXMMC());
//				map.put("GGXH",inventory.getGGXH());
//				map.put("DW",inventory.getDW());
//				map.put("XMSL",inventory.getXMSL());
//				map.put("XMDJ",inventory.getXMDJ());
//				map.put("XMJE",inventory.getXMJE());
 				map.put("XMJSHJ",inventory.getXMJSHJ());
				map.put("SL",inventory.getSL());
//				map.put("SE",inventory.getSE());
//				map.put("HH",inventory.getHH());
//				map.put("ZKHHH",inventory.getZKHHH());
//				map.put("SPBM",inventory.getSPBM());
//				map.put("ZXBM",inventory.getZXBM());
//				map.put("YHZCBS",inventory.getYHZCBS());
//				map.put("LSLBS",inventory.getLSBS());
//				map.put("ZZSTSGL",inventory.getZZSTSGL());
//				map.put("KCE",inventory.getKCE());
				datas.add(map);
			}
			 return datas;
	  }

	public static Map<String, String> buildGetParam(Object obj) {
		Map<String, String> map = new HashMap<>();
		map.put("fpqqlsh", (String)obj);
		return map;
	}

	

}
