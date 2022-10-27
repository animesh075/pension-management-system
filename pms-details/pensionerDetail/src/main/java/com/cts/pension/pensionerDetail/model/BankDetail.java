package com.cts.pension.pensionerDetail.model;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Getter
@Setter
public class BankDetail {
	private String bankName; // Bank Name of the Pensioner Eg. SBI, HDFC etc.
	private String accountNumber; // Account Number of the Pensioner
	private String bankType; // Private or Public

	public String getBankName() {
		return bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBankType() {
		return bankType;
	}

	public BankDetail() {
		super();
	}

	public BankDetail(String bankName, String accountNumber, String bankType) {
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.bankType = bankType;
	}

}
