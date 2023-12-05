package com.yash.ytms.exception;

public class DreyFusReportNotFound extends RuntimeException {

	private String message;

	public DreyFusReportNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
