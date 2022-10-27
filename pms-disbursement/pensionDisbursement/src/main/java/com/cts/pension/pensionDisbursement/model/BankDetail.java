package com.cts.pension.pensionDisbursement.model;


import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BankDetail {
	private String bankName;
	private String accountNumber;
	private String bankType;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public BankDetail(String bankName, String accountNumber, String bankType) {
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.bankType = bankType;
	}
	public BankDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
