package com.niyo.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyo.assignment.model.LoginDbDetails;
import com.niyo.assignment.model.LoginDetail;
import com.niyo.assignment.model.UserDbDetails;
import com.niyo.assignment.model.UserDetails;
import com.niyo.assignment.repository.LoginDetailRepository;
import com.niyo.assignment.repository.UserDetailRepository;

@Service
public class LoginService {

	@Autowired
	LoginDetailRepository loginDetailRepository;
	@Autowired
	UserDetailRepository userDetailRepository;
	
	private boolean validateLogin(LoginDetail login) {
		//fetch from db
		Optional<LoginDbDetails> dbLogin = loginDetailRepository.findById(login.getEmailId());
		if(dbLogin.isPresent()) {
			if(dbLogin.get().getUserPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public UserDetails getUserDetails(LoginDetail login) {
		UserDetails user = new UserDetails();
		if(validateLogin(login)) {
			Optional<UserDbDetails> dbUserDetail = userDetailRepository.findById(login.getEmailId());
			user.setUsername(login.getEmailId());
			UserDbDetails userDetails = dbUserDetail.get();
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setGender(userDetails.getGender());
			user.setPhoneNumber(userDetails.getPhoneNumber());
			user.setDateOfBirth(userDetails.getDateOfBirth());
		return user;
		}
		return null;
	}
}
