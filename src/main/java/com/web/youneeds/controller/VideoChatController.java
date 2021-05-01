package com.web.youneeds.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoChatController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/videoChatPage")
	public String videoChatPage(Locale locale, Model model) {
		logger.info("videoChatPage 페이지 호출");
		
		return "project/videoChatPage";
	}
	
	
}
