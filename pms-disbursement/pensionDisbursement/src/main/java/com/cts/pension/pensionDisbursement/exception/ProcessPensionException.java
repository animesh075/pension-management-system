package com.cts.pension.pensionDisbursement.exception;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ProcessPensionException extends RuntimeException {
	private static final long serialVersionUID = 210649836231358204L;
    private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ProcessPensionException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessPensionException(String message) {
		this.message = message;
	}
    
    
}
