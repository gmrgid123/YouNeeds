package com.web.youneeds.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.biz.interf.ProjectNoticeBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.ProjectDto;
import com.web.youneeds.dto.ProjectFundGuideDto;
import com.web.youneeds.dto.ProjectIntroDto;
import com.web.youneeds.dto.ProjectNoticeDto;
import com.web.youneeds.service.EditorImgUploadService;

@Controller
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@Autowired
	private ProjectNoticeBiz pjnBiz;
	
	@Autowired
	private EditorImgUploadService editorService;
	
	
	//프로젝트 리스트
	@RequestMapping(value="/pjlist.do", method=RequestMethod.GET)
	public String projectlist(Model model, int p, String p_category) {
		logger.info("PROJECT LIST 페이지 호출");
		
		Map map = new HashMap();
		map.put("p", p);
		map.put("p_category", p_category);
		
		int listMax = projectBiz.selectProjectMax(p_category);
		List<ProjectDto> list = projectBiz.selectList(map);
		
		
		int max;
		if(listMax%9 == 0) {
			max = listMax/9;
		}else {
			max = listMax/9 + 1;
		}
		
		int tmp=0;
		if((p%10)==0){
			tmp = p/10;
		}else{
			tmp = p/10 + 1;
		}
		int end_num = tmp*10;
		int start_num = end_num-9;
		
		
		model.addAttribute("plist", list);
		model.addAttribute("listMax", listMax);
		model.addAttribute("max", max);
		model.addAttribute("start_num", start_num);
		model.addAttribute("end_num", end_num);
		
		return "/project/projectlist";
	}
	
	
	//프로젝트 등록 처리
	@RequestMapping(value="/pjinsert.do", method=RequestMethod.POST)
	public String insertProject(HttpServletRequest request, Model model, ProjectDto dto, String p_content, String fund_guide_content, MultipartFile file) {
		logger.info("PROJECT INSERT 호출");
		logger.info("dto :" + dto.toString());
		logger.info("p_content: " + p_content);
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		dto.setCreator_uid(m_uid);
		
		dto.setProjectIntroDto(new ProjectIntroDto(p_content));
		dto.setProjectFundGuideDto(new ProjectFundGuideDto(fund_guide_content));
		
		dto.setProjectTilteImgDto(editorService.titleImgUpload(request, file));
		
		
		
		System.out.println(dto);
		if(projectBiz.insert(dto)==4) {
			return "redirect:pjdetail.do?p_id="+dto.getP_id();
		} else {
			model.addAttribute("msg","프로젝트 등록 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "pjupload.do");
			return "/form/warning";
		}
		
		
	}
	
	//프로젝트 소개 페이지 
	@RequestMapping(value="/pjdetail.do", method=RequestMethod.GET)
	public String projectDetail(int p_id, Model model) {
		logger.info("PROJECT DETAIL 호출");
		
		InetAddress local;
		String ip="";
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		ProjectDto dto = projectBiz.selectDetailIntro(p_id);
		int SumOderPay = projectBiz.sumOrder(p_id);
		int CountOrder = projectBiz.orderCount(p_id);
		
		if(dto != null) {
			model.addAttribute("pDto",dto);
			model.addAttribute("sumOrder", SumOderPay);
			model.addAttribute("orderCount", CountOrder);
			model.addAttribute("chat_addr", ip);
			
			System.out.println(dto);
			
			return "/project/projectintro";
		} else {
			model.addAttribute("msg","프로젝트 조회 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "main.do");
			return "/form/warning";
		}
		
		
	}
	

	//프로젝트 공지사항 리스트
	@RequestMapping("/pjNoticeList")
	public String projectnotice(Model model, int p_id, int page) {
		logger.info("PROJECT NOTICE 페이지 호출");
		
		System.out.println("p_id : "+p_id);
		System.out.println("page : "+page);
		
		InetAddress local;
		String ip="";
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		
		
		int listMax = pjnBiz.selectPjNoticeMaxLength(p_id);
		int tmp=0;
		int max;
		
		if(listMax%5 == 0) {
			max = listMax/5;
		}else {
			max = listMax/5 + 1;
		}
		
		if((page%5)==0) {
			tmp = page/5;
		}else {
			tmp = page/5 + 1;
		}
		
		int end_num = tmp*5;
		int start_num = end_num-4;
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("p_id", p_id);
		map.put("page", page);
		
		ProjectDto inform = projectBiz.selectProjectInform(p_id);
		List<ProjectNoticeDto> nList = pjnBiz.selectList(map);
		int SumOderPay = projectBiz.sumOrder(p_id);
		int CountOrder = projectBiz.orderCount(p_id);
		
		model.addAttribute("chat_addr", ip);
		model.addAttribute("inform", inform);
		model.addAttribute("sumOrder", SumOderPay);
		model.addAttribute("orderCount", CountOrder);
		model.addAttribute("nList", nList);
		model.addAttribute("start_num", start_num);
		model.addAttribute("end_num", end_num);
		model.addAttribute("listMax", listMax);
		model.addAttribute("max", max);
		model.addAttribute("page", page);
		
		return "/project/projectNotice";

	}

	
	
	//펀딩 가이드 페이지
	@RequestMapping("/pjFundGuide")
	public String projectfundingintro(Model model, int p_id) {
		logger.info("PROJECT 펀딩 가이드 페이지 호출");
		
		InetAddress local;
		String ip="";
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		ProjectDto guide = projectBiz.selectProjectJoinGuide(p_id);
		int SumOderPay = projectBiz.sumOrder(p_id);
		int CountOrder = projectBiz.orderCount(p_id);
		
		if(guide != null) {
			model.addAttribute("guide",guide);
			model.addAttribute("sumOrder", SumOderPay);
			model.addAttribute("orderCount", CountOrder);
			model.addAttribute("chat_addr", ip);
			return "/project/projectFundGuide";
		} else {
			model.addAttribute("msg","프로젝트 조회 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "main.do");
			return "/form/warning";
		}
		
		

	}

	
	@RequestMapping("/pjupload.do")
	public String prjoejctupload(Locale locale, Model model) {
		logger.info("PROJECT UPLOAD 페이지 호출");

		return "/project/projectupload";

	}

	// 6.프로젝트 공지 등록
	@RequestMapping("/pjNoticeUploadForm")
	public String projectnoticeuploadPage(Model model,HttpServletRequest request, int p_id) {
		logger.info("PROJECT NOTICE UPLOAD 페이지 호출");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		int writer = projectBiz.selectWriter(p_id);
		
		if(m_uid==writer) {
			return "/project/projectNoticeUpload";
		} else {
			model.addAttribute("msg","작성자 계정이 아닙니다.");
			model.addAttribute("pageUrl", "pjdetail.do?p_id="+p_id);
			return "/form/warning";
		}
		
	}
	
	
	
	
	@RequestMapping(value="/uploadImg/projectContent", method = RequestMethod.POST)
	public void projectContentImgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("Project 소개 이미지 업로드 처리");
		
		String path = "/uploadImg/projectContent";
		editorService.ImgUpload(request, response, upload, path);
		
	}
	
	//프로젝트 공지 상세 페이지
	@RequestMapping("/pjNoticeView")
	public String projectNoticeView(Model model, int p_id, int no) {
		logger.info("프로젝트 공지 상세 페이지 호출");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("p_id", p_id);
		map.put("no", no);
		
		ProjectNoticeDto dto = pjnBiz.selectOne(map);
		
		
		if(dto != null) {
			model.addAttribute("dto", dto);
			return "/project/projectNoticeView";
		}else {
			model.addAttribute("msg","조회 중 문제가 발생했습니다.");
			model.addAttribute("pageUrl", "pjdetail.do?p_id="+p_id);
			return "/form/warning";
		}
		
	}
	
	
	
	@RequestMapping(value="/prjNoticeInsert.do", method = RequestMethod.POST)
	public String projectNotice(Model model, HttpServletRequest request, ProjectNoticeDto dto) {
		logger.info("프로젝트 공지 업로드 처리");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		int writer = projectBiz.selectWriter(dto.getP_id());
		
		if(m_uid==writer) {
			
			if(pjnBiz.insert(dto)>0) {
				return "redirect:pjNoticeView?p_id="+dto.getP_id()+"&no="+dto.getP_notice_no();
			} else {
				model.addAttribute("msg","업로드 중 문제가 발생했습니다.");
				model.addAttribute("pageUrl", "pjdetail.do?p_id="+dto.getP_id());
				return "/form/warning";
			}
			
			
			
		} else {
			model.addAttribute("msg","작성자 계정이 아닙니다.");
			model.addAttribute("pageUrl", "pjdetail.do?p_id="+dto.getP_id());
			return "/form/warning";
		}
		
		
	}
	
	
	@RequestMapping(value="/uploadImg/pjNotice", method = RequestMethod.POST)
	public void projectNoticeImgUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("Project 소개 이미지 업로드 처리");
		
		String path = "/uploadImg/pjNotice";
		editorService.ImgUpload(request, response, upload, path);
		
		
	}
	
	
}
