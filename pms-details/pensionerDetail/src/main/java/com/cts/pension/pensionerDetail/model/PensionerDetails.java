package com.cts.pension.pensionerDetail.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.*;

@Entity
@Getter
@Setter
@Component
@Table(name = "details")
public class PensionerDetails {

	@Id
	private String aadharNumber;
	private String name;
	private String dateOfBirth;
	private String panNumber;
	private double salary;
	private double allowances;
	private String pensionType;
	@Embedded
	private BankDetail bankDetail;

	public PensionerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionerDetails(String aadharNumber, String name, String dateOfBirth, String panNumber, double salary,
			double allowances, String pensionType, BankDetail bankDetail) {
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.salary = salary;
		this.allowances = allowances;
		this.pensionType = pensionType;
		this.bankDetail = bankDetail;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}

	public BankDetail getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}

}
