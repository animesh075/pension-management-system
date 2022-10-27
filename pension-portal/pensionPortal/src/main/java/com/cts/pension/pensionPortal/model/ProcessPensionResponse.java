package com.cts.pension.pensionPortal.model;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
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

//	public ProcessPensionResponse(int processPensionStatusCode) {
//		this.processPensionStatusCode = processPensionStatusCode;
//	}
}
