package com.niyo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niyo.assignment.model.LoginDetail;
import com.niyo.assignment.model.Response;
import com.niyo.assignment.model.SignUpDetails;
import com.niyo.assignment.model.UserDetails;
import com.niyo.assignment.service.LoginService;

@RestController
public class NiyoRestController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Response<UserDetails> login(LoginDetail login) {
		Response<UserDetails> resp = new Response<UserDetails>();
		UserDetails userDetails = loginService.getUserDetails(login);
		if(userDetails == null) {
			resp.setMessage("User details not found.");
		}
		else {
			resp.setMessage("User details found.");
		}
		resp.setPayload(userDetails);
		return resp;
	}
	
	@RequestMapping(value = "/new_user", method = RequestMethod.POST, headers = "Content-Type = application/x-www-form-urlencoded")
	public Response<String> signup(SignUpDetails signup) {
		Response<String> resp = new Response<String>();
		resp.setMessage("User sign up successful.");
		resp.setPayload("Created user successfully.");
		return resp;
	}

}
