package com.yash.ytms.exception;

import org.springframework.http.HttpStatus;

public class TrainerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private HttpStatus httpStatus;

	public TrainerNotFound(String message) {
		super();
		this.message = message;
	}

	public TrainerNotFound(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}