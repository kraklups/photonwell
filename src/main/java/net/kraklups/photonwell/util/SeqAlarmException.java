package net.kraklups.photonwell.util;

public class SeqAlarmException extends RuntimeException {

	private static final long serialVersionUID = -9006292117570223485L;

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

	public SeqAlarmException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public SeqAlarmException(String errMsg) {
		this.errMsg = errMsg;
	}

}
