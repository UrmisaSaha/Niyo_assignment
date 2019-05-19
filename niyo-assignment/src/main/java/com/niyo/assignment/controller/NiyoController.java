package com.niyo.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NiyoController {

	@RequestMapping("/")
	public String signupPage() {
		return "signup";
	}
}
