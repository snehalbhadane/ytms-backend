package com.yash.ytms.exception;

public class TrainerNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TrainerNotFound(String message) {
		super(message);
	}
}