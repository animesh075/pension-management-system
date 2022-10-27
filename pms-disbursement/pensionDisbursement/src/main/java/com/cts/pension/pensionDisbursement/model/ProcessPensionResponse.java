package com.cts.pension.pensionDisbursement.model;

import org.springframework.stereotype.Component;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class ProcessPensionResponse {
	private int processPensionStatusCode;

	public int getProcessPensionStatusCode() {
		return processPensionStatusCode;
	}

	public void setProcessPensionStatusCode(int processPensionStatusCode) {
		this.processPensionStatusCode = processPensionStatusCode;
	}

	public ProcessPensionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessPensionResponse(int processPensionStatusCode) {
		this.processPensionStatusCode = processPensionStatusCode;
	}
	
}
