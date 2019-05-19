package com.niyo.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyo.assignment.model.LoginDbDetails;
import com.niyo.assignment.model.LoginDetail;
import com.niyo.assignment.model.UserDetails;
import com.niyo.assignment.repository.LoginDetailRepository;

@Service
public class LoginService {

	@Autowired
	LoginDetailRepository loginDetailRepository;
	
	private boolean validateLogin(LoginDetail login) {
		//fetch from db
		Optional<LoginDbDetails> dbLogin = loginDetailRepository.findById(login.getEmailId());
		dbLogin.isPresent();
		return false;
	}
	
	public UserDetails getUserDetails(LoginDetail login) {
		validateLogin(login);
		return null;
	}
}
