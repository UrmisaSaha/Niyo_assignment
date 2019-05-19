package com.niyo.assignment.service;

import org.springframework.stereotype.Service;

import com.niyo.assignment.model.LoginDetail;
import com.niyo.assignment.model.UserDetails;

@Service
public class LoginService {

	private boolean validateLogin(LoginDetail login) {
		//fetch from db
		return false;
	}
	
	public UserDetails getUserDetails(LoginDetail login) {
		
		return null;
	}
}
