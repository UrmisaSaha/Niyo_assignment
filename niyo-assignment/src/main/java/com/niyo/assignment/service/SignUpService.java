package com.niyo.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niyo.assignment.model.LoginDetail;
import com.niyo.assignment.model.SignUpDbDetails;
import com.niyo.assignment.model.SignUpDetails;
import com.niyo.assignment.model.UserDetails;
import com.niyo.assignment.repository.SignUpDetailRepository;

@Service
public class SignUpService {

	@Autowired
	SignUpDetailRepository signUpDetailRepository;
	@Autowired
	LoginService loginService;
	
	public UserDetails signup(SignUpDetails signup) {
		SignUpDbDetails signUpDbDetails = new SignUpDbDetails();
		signUpDbDetails.setLastName(signup.getLastName());
		signUpDbDetails.setPhoneNumber(signup.getPhoneNumber());
		signUpDbDetails.setGender(signup.getGender());
		signUpDbDetails.setFirstName(signup.getFirstName());
		signUpDbDetails.setDateOfBirth(signup.getDateOfBirth());
		signUpDbDetails.setUserId(signup.getUsername());
		signUpDbDetails.setUserPassword(signup.getPassword());
		SignUpDbDetails dbResponse = signUpDetailRepository.save(signUpDbDetails);
		if(dbResponse != null) {
			return loginService.getUserDetails(new LoginDetail(dbResponse.getUserId(), dbResponse.getUserPassword()));
		}
		return null;
	}
}
