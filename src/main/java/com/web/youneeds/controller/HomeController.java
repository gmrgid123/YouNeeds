package com.web.youneeds.controller;

import java.util.List;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dto.ProjectDto;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	// 메인페이지
	@RequestMapping("/main.do")
	public String main(Locale locale, Model model) {
		logger.info("main 페이지 호출");
		
		List<ProjectDto> recentList = projectBiz.selectRecentList();
		
		System.out.println(recentList);
		
		model.addAttribute("recentList", recentList);
		
		return "main";
	}
	
	
	
	
	
}
