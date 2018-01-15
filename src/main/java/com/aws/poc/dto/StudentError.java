package com.aws.poc.dto;

import java.io.Serializable;

public class StudentError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	private String errorMessage;

	public StudentError(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
