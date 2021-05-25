package com.web.youneeds.controller;

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

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dto.MemberDto;

@Controller
public class MyPageController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberBiz memberBiz;
	
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
		
		if(dto.getM_type().equals("일반") || dto.getM_type().equals("관리")) {
			return "/mypage/userMypage";
		} else {
			return "/mypage/creatorMypage";
		}
		
	}
	
}
