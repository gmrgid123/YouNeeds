package com.web.youneeds.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.youneeds.biz.interf.CreatorBiz;
import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.OrderDto;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OrderBiz orderBiz;
	private CreatorBiz creatorBiz;
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		logger.info("Logout 성공");
		
		return "redirect:/";
	}
	
	//비밀번호 확인 테스트
	@RequestMapping("/pwdCheckTest")
	public String PwdCheck() {
		logger.info("회원정보 수정 이전의 비밀번호 체크 페이지 호출 테스트");
		
		return "login/update_general_create";
	}
	
	//마이페이지
	@RequestMapping("/userUpdate")
	public String userMypageUpdate(Locale locale, Model model) {
		logger.info("userMypage 업데이트 페이지 호출");
				
		return "login/updategeneral";
	}
			
	@RequestMapping("/creatorUpdate")
	public String creatorMypageUpdate(Locale locale, Model model) {
		logger.info("creatorMypage 업데이트 페이지 호출");
				
		return "login/updatecreate";
	}
	
	@RequestMapping("/userMypage")
	public String selectOne(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("userMypage 호출");
		
		MemberDto dto = (MemberDto)request.getSession().getAttribute("login");
		List<OrderDto> user = orderBiz.myPageInfo(dto.getM_uid());
		//List<CreatorDto> creator = creatorBiz.creatorPageInfo(dto.getM_uid());
		
		
		
		if(dto.getM_type().equals("일반") || dto.getM_type().equals("관리")) {
			model.addAttribute("user", user);
			return "/mypage/userMypage";
		} else {
			model.addAttribute("user", user);
			//model.addAttribute("creator", creator);
			return "/mypage/creatorMypage";
		}
		
	}
	
}
