package com.cts.pension.pensionDisbursement.model;

import org.springframework.stereotype.Component;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class ProcessPensionInput {

	private String aadharNumber;
	private double pensionAmount;
	private double serviceCharge;

	public ProcessPensionInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessPensionInput(String aadharNumber, double pensionAmount, double serviceCharge) {
		this.aadharNumber = aadharNumber;
		this.pensionAmount = pensionAmount;
		this.serviceCharge = serviceCharge;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

}
