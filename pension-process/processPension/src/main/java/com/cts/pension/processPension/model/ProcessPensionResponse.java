package com.cts.pension.processPension.model;

import lombok.Getter;
import lombok.Setter;

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

	public ProcessPensionResponse(int processPensionStatusCode) {
		this.processPensionStatusCode = processPensionStatusCode;
	}

	public ProcessPensionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
