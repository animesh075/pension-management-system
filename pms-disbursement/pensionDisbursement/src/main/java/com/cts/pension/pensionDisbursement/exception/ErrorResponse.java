package com.cts.pension.pensionDisbursement.exception;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ErrorResponse {
	private String message;
	private int statusCode;
	private Long exceptionTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Long getExceptionTime() {
		return exceptionTime;
	}

	public void setExceptionTime(Long exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

	public ErrorResponse(String message, int statusCode, Long exceptionTime) {
		this.message = message;
		this.statusCode = statusCode;
		this.exceptionTime = exceptionTime;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
