package com.web.youneeds.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/list.do")
	public String projectlist(Locale locale, Model model) {
		logger.info("PROJECT LIST 페이지 호출");
		
		return "/project/projectlist";

	}
	
	@RequestMapping("/pjupload.do")
	public String projectupload(Locale locale, Model model) {
		logger.info("PROJECT UPLOAD 페이지 호출");
		
		return "/project/projectupload";

	}
	
	@RequestMapping("/pjdetail.do")
	public String projectdetail(Locale locale, Model model) {
		logger.info("PROJECT DETAIIL 페이지 호출");
		
		return "/project/projectdetail";

	}
	
	@RequestMapping("/pjnotice.do")
	public String projectnotice(Locale locale, Model model) {
		logger.info("PROJECT NOTICE 페이지 호출");
		
		return "/project/projectnotice";

	}
	
	@RequestMapping("/pjform.do")
	public String introfunding(Locale locale, Model model) {
		logger.info("PROJECT FORM 페이지 호출");
		
		return "/project/projectform";

	}
	@RequestMapping("/pjupnotice.do")
	public String projectnoticeupload(Locale locale, Model model) {
		logger.info("PROJECT NOTICE UPLOAD 페이지 호출");
		
		return "/project/projectnoticeupload";

	}
}
