package net.kraklups.photonwell.util;

public class SeqDataValueException extends RuntimeException {

	private static final long serialVersionUID = -6713491591414045083L;

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

	public SeqDataValueException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public SeqDataValueException(String errMsg) {
		this.errMsg = errMsg;
	}
}
