package net.kraklups.photonwell.util;

public class SeqEventTskException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5351974635448531946L;
	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public SeqEventTskException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public SeqEventTskException(String errMsg) {
		this.errMsg = errMsg;
	}

}