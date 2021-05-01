package com.web.youneeds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/login.do")
	public String login() {
		logger.info("login 페이지");
		
		return "login/login";
	}
	
	@RequestMapping("/general_create.do")
	public String general_create() {
		logger.info("general_create 페이지");
		
		return "login/general_create";
	}
	
	
	@RequestMapping("/general.do")
	public String general() {
		logger.info("general 페이지");
		
		return "login/general";
	}
	
	@RequestMapping("/create.do")
	public String create() {
		logger.info("create 페이지");
		
		return "login/create";
	}
}
