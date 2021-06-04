package com.web.youneeds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.biz.interf.ProjectIntroBiz;
import com.web.youneeds.dto.ProjectDto;
import com.web.youneeds.dto.ProjectIntroDto;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@Autowired
	private ProjectIntroBiz projectIntroBiz;
	
	/**
	 * 프로젝트 리스트 조회
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
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
	
	/**
	 * 프로젝트, 프로젝트 소개 등록
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/pjinsert.do", method=RequestMethod.POST)
	public String insertProject(Model model, ProjectDto dto) {
		logger.info("PROJECT INSERT 호출");
		logger.info("dto :" + dto.toString());
		logger.info("p_content: " + dto.getP_content());
		
		// 프로젝트 insert
		projectBiz.insert(dto);
		// 프로젝트 소개 insert
		ProjectIntroDto projectIntroDto = new ProjectIntroDto();
		projectIntroDto.setP_id(dto.getP_id());
		projectIntroDto.setP_intro(dto.getP_content());
		projectIntroBiz.insert(projectIntroDto);
		// 프로젝트 안내 insert
		// TODO
		// 프로젝트 소개 외에도 필요한 것들 insert
		return "redirect:pjlist.do";
	}
	
	/**
	 * 프로젝트 상세 조회
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/pjdetail.do", method=RequestMethod.GET)
	public String projectDetail(ProjectDto dto, HttpServletRequest request, Model model) {
		//int p_id = Integer.parseInt(request.getParameter("p_id"));
		int p_id = ServletRequestUtils.getIntParameter(request, "p_id", 0);
		logger.info("PROJECT DETAIL 호출");
		
		model.addAttribute("pjdetail", projectBiz.selectOne(p_id));
		return "/project/projectintro";
	}
	
	/**
	 * 프로젝트 소개, 공지, 펀딩안내 비동기 조회
	 * @param paramMap
	 * @param requset
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/pjloadscr.do", method=RequestMethod.POST)
	public ResponseEntity<?> projectLoadScr(@RequestParam Map<String, Object> paramMap, HttpServletRequest requset, Model model) {
		Map<String, Object> resultMap = new HashMap<>();
		
		// 소개, 공지, 펀딩안내에 따라 각 테이블 데이터 조회
		// if("intro".equals(paramMap.get("category")) {
			// 파라미터 세팅
			// ProjectIntroDto projectIntroDto = new ProjectIntroDto();
			// projectIntroDto.setP_id(paramMap.get("p_id"));
			// 데이터 조회 (공지는 Map이 아니라 List형태 (프로젝트 리스트 형태), 조회한 리스트는 맵에 넣을것)
			// Map<ProjectIntroDto> introDto = projectIntroBiz.selectOne(projectIntroDto);
			// 데이터 맵에 넣기
			// resultMap.put("p_intro", introDto.get("p_intro"));
		// } else if...
		
		resultMap.put("test_value", "abcd");
		return ResponseEntity.ok(resultMap);
	}
	
	// 2. 프로젝트 소개
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
