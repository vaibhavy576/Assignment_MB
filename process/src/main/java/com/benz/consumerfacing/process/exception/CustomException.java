package com.benz.consumerfacing.process.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;

	public CustomException(String msg) {
		super(msg);
	}

	public CustomException(CustomErrorCodes customErrorCode) {
		super(customErrorCode.getDescription());
		this.errorCode = customErrorCode.getErrorCode();
	}
}