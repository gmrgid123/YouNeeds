package com.web.youneeds.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	//마이페이지
	@RequestMapping("/userMypage")
	public String userMypage(Locale locale, Model model) {
		logger.info("userMypage 페이지 호출");
			
		return "mypage/userMypage";
	}
		
	@RequestMapping("/creatorMypage")
	public String creatorMypage(Locale locale, Model model) {
		logger.info("creatorMypage 페이지 호출");
		
		return "mypage/creatorMypage";
	}
	
}
