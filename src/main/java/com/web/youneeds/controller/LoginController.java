package com.web.youneeds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dto.MemberDto;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@RequestMapping("/login.do")
	public String login() {
		logger.info("login 페이지");
		
		return "login/login";
	}
	
	@RequestMapping("/general_create.do")
	public String general_create() {
		logger.info("general_create 페이지");
		
		return "login/general_create";
	}
	
	
	@RequestMapping("/general.do")
	public String general() {
		logger.info("general 페이지");
		
		return "login/general";
	}
	
	@RequestMapping("/join.do") //회원가입
	public String insert_general(MemberDto dto) {
		logger.info("insert_general");
		
		int res = biz.insert(dto);
		if(res>0) {
			return "redirect:login.do";
		}else {
			return "redirect:general.do";
		}	
	}
	
	@RequestMapping(value="/nicknameChk", method=RequestMethod.POST)
	@ResponseBody
	public String nicknameChk(MemberDto dto) throws Exception{
		logger.info("nickname() 진입");
		
		int result = biz.nicknameChk(dto);
		
		logger.info("결과값="+result);
		
		if(result !=0) {
			return "fail";
		}else {
			return "success";
		}
	}
	
	@RequestMapping("/create.do")
	public String create() {
		logger.info("create 페이지");
		
		return "login/create";
	}
	
	@RequestMapping("/found_pw")
	public String foundPw() {
		logger.info("패스워드 찾기 페이지");
		
		return "login/foundPw";
	}
}
