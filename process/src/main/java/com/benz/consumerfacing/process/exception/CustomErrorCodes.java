package com.benz.consumerfacing.process.exception;

public enum CustomErrorCodes {
	
	
    UNABLE_TO_SAVE("UNABLE_TO_SAVE","Unable to save the Json value");
	
	private final String errorCode;
	private final String description;	
	
	CustomErrorCodes(String errorCode, String description){
		this.errorCode = errorCode;
		this.description = description;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}

	public String getDescription() {
		return this.description;
	}

}