package com.yonyou.einvoice.sdk.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import java.util.Map;

import org.bouncycastle.util.io.pem.PemReader;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

/**
 * @author admin
 * @date 2017年3月4日 
 */
public class Signature {
	
	public static String sign(Map<String, String> paramsMap) throws Exception {

	    // 读取CA证书与PEM格式证书需要根据实际证书使用情况而定,目前这两种都支持
	     PrivateKey privateKey = loadPrivateKeyOfCA();
	    //PrivateKey privateKey = loadPrivateKeyOfPem();

	    Map<String, Object> claims =
	        JwtParamBuilder.build().setSubject("tester").setIssuer("einvoice").setAudience("einvoice")
	            .addJwtId().addIssuedAt().setExpirySeconds(300).setNotBeforeSeconds(300).getClaims();

	    // 需要将表单参数requestdatas的数据进行md5加密，然后放到签名数据的requestdatas中。
	    // 此签名数据必须存在，否则在验证签名时会不通过。
	    String value = paramsMap.get("fpqqlsh");
	    if(value==null){
	    value = paramsMap.get("requestdatas");}
	    //String value = "".equals(paramsMap.get("requestdatas"))?paramsMap.get("fpqqlsh"):paramsMap.get("requestdatas");
	    //String value =  paramsMap.get("requestdatas");
	    //if(value.equals(anObject))
	    //if(value!=null){
	    	claims.put("requestdatas", getMD5(value));
	    //}elsei
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
}
