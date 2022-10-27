package com.cts.pension.pensionPortal.model;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ProcessPensionInput {

	private String aadharNumber;
	private Double pensionAmount;
	private Double serviceCharge;

	public ProcessPensionInput() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ProcessPensionInput(String aadharNumber, Double pensionAmount, Double serviceCharge) {
//		this.aadharNumber = aadharNumber;
//		this.pensionAmount = pensionAmount;
//		this.serviceCharge = serviceCharge;
//	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(Double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
}
