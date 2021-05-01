package com.web.youneeds.controller;

import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 메인페이지
	@RequestMapping("/main.do")
	public String main(Locale locale, Model model) {
		logger.info("main 페이지 호출");
		
		return "main";
	}
	
	
	
	
	
}
