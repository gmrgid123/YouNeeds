package com.web.youneeds.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dto.ProjectDto;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	// 1. 프로젝트 전체 리스트
	@RequestMapping("/pjlist.do")
	public String projectlist(Locale locale, Model model) {
		logger.info("PROJECT LIST 페이지 호출");

		return "/project/projectlist";
	}
	
	@RequestMapping(value="/pjinsert.do", method=RequestMethod.POST)
	public String insertProject(Model model, ProjectDto dto) {
		logger.info("PROJECT INSERT 호출");
		logger.info("dto :" + dto.toString());
		projectBiz.insert(dto);
		return "/project/projectlist";
	}
	// 2. 프로젝트 소개
	@RequestMapping("/pjintro.do")
	public String projectintro(Locale locale, Model model) {
		logger.info("PROJECT INTRO 페이지 호출");

		return "/project/projectintro";

	}

	// 3. 프로젝트 공지
	@RequestMapping("/pjnotice.do")
	public String projectnotice(Locale locale, Model model) {
		logger.info("PROJECT NOTICE 페이지 호출");

		return "/project/projectnotice";

	}

	// 4. 펀딩안내
	@RequestMapping("/pjfunding.do")
	public String projectfundingintro(Locale locale, Model model) {
		logger.info("PROJECT FUNDING 페이지 호출");

		return "/project/projectfundingintro";
	}

	// 5. 프로젝트 등록
	@RequestMapping("/pjupload.do")
	public String prjoejctupload(Locale locale, Model model) {
		logger.info("PROJECT UPLOAD 페이지 호출");

		return "/project/projectupload";

	}

	// 6.프로젝트 공지 등록
	@RequestMapping("/pjupnotice.do")
	public String projectnoticeupload(Locale locale, Model model) {
		logger.info("PROJECT NOTICE UPLOAD 페이지 호출");

		return "/project/projectnoticeupload";

	}

}
