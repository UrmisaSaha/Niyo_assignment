package com.niyo.assignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDbDetails {
	@Id
	String userId;
	String userPassword;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
