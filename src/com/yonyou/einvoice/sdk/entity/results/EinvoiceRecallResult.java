package com.yonyou.einvoice.sdk.entity.results;
/**
 * @author huangshengxin
 * @date 2017年3月6日 
*/
public class EinvoiceRecallResult extends EinvoiceBaseResult {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -6659986873947492982L;
	/**
	 * 数据
	 */
	private String data;
	/**
	 * 使用Base64解码为二进制流，可以保存为pdf文件
	 */
	private String pdf;
	/**
	 * 请求流水号
	 */
	private String fpqqlsh;
	/**
	 * 分享地址连接
	 */
	private String shareurl;
	/**
	 * 分享密码
	 */
	private String sharecode;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getFpqqlsh() {
		return fpqqlsh;
	}
	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}
	public String getShareurl() {
		return shareurl;
	}
	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}
	public String getSharecode() {
		return sharecode;
	}
	public void setSharecode(String sharecode) {
		this.sharecode = sharecode;
	}
	@Override
	public String toString() {
		return "EinvoiceRecallResult [data=" + data + ", pdf=" + pdf + ", fpqqlsh=" + fpqqlsh + ", shareurl=" + shareurl
				+ ", sharecode=" + sharecode + ", code=" + code + ", msg=" + msg + "]";
	}
	
}
