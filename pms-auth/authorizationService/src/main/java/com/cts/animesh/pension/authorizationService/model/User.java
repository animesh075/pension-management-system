package com.cts.animesh.pension.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.*;

@Component
@Entity
@Data
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "Id")
	private String id;
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String username;
	@Column(name = "authToken")
	private String authToken;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String password, String username, String authToken) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.authToken = authToken;
	}
	
	

}
