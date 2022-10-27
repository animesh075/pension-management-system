package com.cts.pension.processPension.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class PensionerInput {
	private String name;
	private String dateOfBirth;
	private String panNumber;
	private String aadharNumber;
	private String pensionType;

	public PensionerInput(String name, String dateOfBirth, String panNumber, String aadharNumber, String pensionType) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.pensionType = pensionType;
	}

	public PensionerInput() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadhaarNumber) {
		this.aadharNumber = aadhaarNumber;
	}

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

}
