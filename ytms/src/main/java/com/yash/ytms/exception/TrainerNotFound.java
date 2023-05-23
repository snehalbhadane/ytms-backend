package com.yash.ytms.exception;

public class TrainerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public TrainerNotFound(String message) {
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