package com.cts.pension.processPension.model;

import org.springframework.stereotype.Component;

//import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class ProcessPensionInput {

	private String aadharNumber;
	private Double pensionAmount;
	private Double serviceCharge;

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

	public ProcessPensionInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessPensionInput(String aadharNumber, Double pensionAmount, Double serviceCharge) {
		this.aadharNumber = aadharNumber;
		this.pensionAmount = pensionAmount;
		this.serviceCharge = serviceCharge;
	}
	

}
