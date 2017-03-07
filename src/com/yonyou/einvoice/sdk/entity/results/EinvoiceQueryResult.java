package com.yonyou.einvoice.sdk.entity.results;

/**
 * @author huangshengxin
 * @date 2017年3月3日 
*/
public class EinvoiceQueryResult extends EinvoiceBaseResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1192270825017529565L;
	/**
	 * 发票请求流水号
	 */
	private String fpqqlsh;
	/**
	 * 状态码
	 */
	private String statuscode;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 错误信息
	 */
	private String errmsg;
	/**
	 * 
	 */
	private String data;
	
	public String getFpqqlsh() {
		return fpqqlsh;
	}
	public void setFpqqlsh(String fpqqlsh) {
		this.fpqqlsh = fpqqlsh;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "EinvoiceQueryResult [fpqqlsh=" + fpqqlsh + ", statuscode=" + statuscode + ", status=" + status
				+ ", errmsg=" + errmsg + ", data=" + data + ", code=" + code + ", msg=" + msg + "]";
	}
	
}
