package com.cts.pension.pensionPortal.model;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class PensionDetail {
	private String name;
	private String dateOfBirth;
	private String panNumber;
	private String pensiontype;
	private double pensionAmount;

	public PensionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public PensionDetail(String name, String dateOfBirth, String panNumber, String pensiontype, double pensionAmount) {
//		this.name = name;
//		this.dateOfBirth = dateOfBirth;
//		this.panNumber = panNumber;
//		this.pensiontype = pensiontype;
//		this.pensionAmount = pensionAmount;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPensiontype() {
		return pensiontype;
	}

	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}

	public double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

}
