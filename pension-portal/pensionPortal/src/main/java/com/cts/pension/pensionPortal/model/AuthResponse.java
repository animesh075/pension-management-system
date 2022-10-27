package com.cts.pension.pensionPortal.model;

import lombok.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor

public class AuthResponse {
	
	private String userName;
	private String password;
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public AuthResponse(String userName, String password) {
//		this.userName = userName;
//		this.password = password;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	


}
