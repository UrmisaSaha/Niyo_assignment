package com.niyo.assignment.model;

public class LoginDetail {
	String emailId;
	String password;
	
	public LoginDetail() {};
	public LoginDetail(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
