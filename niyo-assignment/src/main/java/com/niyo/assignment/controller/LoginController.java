package com.niyo.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niyo.assignment.model.LoginDetail;

@RestController
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	String validateLogin(LoginDetail login) {
		System.out.println(login.getEmailId());
		System.out.println(login.getPassword());
		return "correct";
	}

}
