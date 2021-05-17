package com.web.youneeds.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
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
	@RequestMapping(value="/pjlist.do", method=RequestMethod.GET)
	public String projectlist(Locale locale, ModelMap model, HttpServletRequest request) {
		logger.info("PROJECT LIST 페이지 호출");
		ProjectDto dto = new ProjectDto();
		
		// 1번 request에서 데이터를 가져오는 기초적인 방법 (값이 없을때 NullPointerException)
		String p_category = request.getParameter("p_category") == null ? "" : request.getParameter("p_category");
		// 2번 Spring에서 제공하는 ServletRequestUtils 이용 (default값 지정 가능)
		// String p_category = ServletRequestUtils.getStringParameter(request, "p_category", "");
		// 조회조건 Set
		dto.setP_category(p_category);
		logger.info("category?: " + p_category);
		
		// 리스트 조회
		List<ProjectDto> list = projectBiz.selectList(dto);
		logger.info("list : " + list.toString());
		
		// 화면에 보낼 값 Set
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
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

		return "/project/projectfunding";
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
