package com.cts.pension.pensionPortal.model;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Token {

	String token;

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Token(String token) {
//		this.token = token;
//	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
