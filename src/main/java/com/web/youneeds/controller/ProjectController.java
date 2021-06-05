package com.web.youneeds.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.ProjectDto;
import com.web.youneeds.dto.ProjectFundGuideDto;
import com.web.youneeds.dto.ProjectIntroDto;
import com.web.youneeds.dto.ProjectTitleImgDto;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
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
	public String insertProject(HttpServletRequest request, Model model, ProjectDto dto, String p_content, String fund_guide_content, MultipartFile file) {
		logger.info("PROJECT INSERT 호출");
		logger.info("dto :" + dto.toString());
		logger.info("p_content: " + p_content);
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		dto.setCreator_uid(m_uid);
		
		dto.setProjectIntroDto(new ProjectIntroDto(p_content));
		dto.setProjectFundGuideDto(new ProjectFundGuideDto(fund_guide_content));
		
		
		String originName; String storedName; String uploadPath; int fileSize;
		UUID uuid = UUID.randomUUID();
		OutputStream out = null;
		
		if(file != null) {
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						originName = file.getOriginalFilename();
						byte[] bytes = file.getBytes();
						fileSize = file.getBytes().length;
						uploadPath = request.getServletContext().getRealPath("/uploadImg/projectTitle");
						
						
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						storedName = uuid + "_" + originName;
						out = new FileOutputStream(new File(uploadPath+"/"+storedName));
						out.write(bytes);
						out.flush();
						
						dto.setProjectTilteImgDto(new ProjectTitleImgDto(originName, storedName, uploadPath, fileSize));
						
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		System.out.println(dto);
		if(projectBiz.insert(dto)==4) {
			return "redirect:pjdetail.do?p_id="+dto.getP_id();
		} else {
			model.addAttribute("msg","프로젝트 등록 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "pjupload.do");
			return "/form/warning";
		}
		
		
	}
	
	@RequestMapping(value="/pjdetail.do", method=RequestMethod.GET)
	public String projectDetail(int p_id, Model model) {
		logger.info("PROJECT DETAIL 호출");
		
		ProjectDto dto = projectBiz.selectDetailIntro(p_id);
		int SumOderPay = projectBiz.sumOrder(p_id);
		int CountOrder = projectBiz.orderCount(p_id);
		
		if(dto != null) {
			model.addAttribute("pDto",dto);
			model.addAttribute("sumOrder", SumOderPay);
			model.addAttribute("orderCount", CountOrder);
			
			System.out.println(dto);
			
			return "/project/projectintro";
		} else {
			model.addAttribute("msg","프로젝트 조회 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "main.do");
			return "/form/warning";
		}
		
		
	}

	
	// 2. 프로젝트 소개
	public String projectintro(Locale locale, Model model) {
		logger.info("PROJECT INTRO 페이지 호출");
		
		return "/project/projectintro";

	}

	// 3. 프로젝트 공지
	@RequestMapping("/pjNotice")
	public String projectnotice(Model model, int p_id, Integer page) {
		logger.info("PROJECT NOTICE 페이지 호출");

		ProjectDto inform = projectBiz.selectProjectInform(p_id);
		
		
		
		model.addAttribute("inform", inform);
		
		
		return "/project/projectNotice";

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
	
	
	
	
	@RequestMapping(value="/uploadImg/projectContent", method = RequestMethod.POST)
	public void projectContentImgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("Project 소개 이미지 업로드 처리");
		
		JsonObject json = new JsonObject();
		OutputStream out = null;
		PrintWriter printWriter = null;
		//랜덤 문자 생성
		UUID uuid = UUID.randomUUID();
		
		if(upload != null) {
			if(upload.getSize() > 0 && StringUtils.isNotBlank(upload.getName())) {
				if(upload.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						String originName = upload.getOriginalFilename();
						byte[] bytes = upload.getBytes();
						String uploadPath = request.getServletContext().getRealPath("/uploadImg/projectContent");
						
						
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						String storedName = uuid + "_" + originName;
						out = new FileOutputStream(new File(uploadPath+"/"+storedName));
						out.write(bytes);
						out.flush();
						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + "/uploadImg/projectContent/" + storedName;
						
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", storedName);
						json.addProperty("url", fileUrl);
						
						printWriter.println(json);
						printWriter.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						
						try {
							out.close();
							printWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
	
}
