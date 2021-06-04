package com.web.youneeds.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.youneeds.biz.interf.CreatorBiz;
import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberBiz biz;
	@Autowired
	private CreatorBiz c_biz;
	
	@RequestMapping("/loginForm.do")
	public String login() {
		logger.info("login 페이지");
		return "login/login";
	}
	
	/* 로그인 */
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public  String login(HttpServletRequest req, RedirectAttributes rttr, MemberDto dto, CreatorDto cdto) throws Exception{
		logger.info("login 페이지");
				
				System.out.println("login 메서드 진입");
				HttpSession session =req.getSession();
				MemberDto login = biz.login(dto);
				System.out.println(login);
				
				if(login == null) {
					session.setAttribute("member", null);
					rttr.addFlashAttribute("msg", false);
					System.out.println("로그인실패");
					return "redirect:loginForm.do";
				}else {
					session.setAttribute("member", login);
					System.out.println("로그인성공");
					return "redirect:main.do";
				}
				
	}
	
	/* 로그아웃 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:main.do";
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
	
	/* 일반 회원가입 */
	@RequestMapping("/insert.do")
	public String insert_general(MemberDto dto) {
		logger.info("insert_general");
		System.out.println("dto : " + dto);
		int res = biz.insert(dto);
		if(res>0) {
			return "redirect:loginForm.do";
		}else {
			return "redirect:general.do";
		}	
	}
	
	/* 창작 회원가입 */
	@RequestMapping("/c_insert.do")
	public String insert_create(CreatorDto dto) {
		logger.info("insert_create");
		System.out.println("dto : " + dto);
		int res = c_biz.insert(dto);
		if(res>0) {
			return "redirect:loginForm.do";
		}else {
			return "redirect:create.do";
		}	
	}
	
	/* 닉네임 중복 */
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
	
	/* 일반회원 수정 */
	@RequestMapping("/update.do")
	public String update_general(MemberDto dto, HttpSession session) {
		logger.info("UPDATE");
		System.out.println("UPDATE");
		System.out.println("dto : " + dto);
		int res = biz.update(dto);
		session.invalidate();
		return "redirect:loginForm.do";
	}
	
	/* 창작회원 수정 */
	@RequestMapping("/c_update.do")
	public String update_create(MemberDto mdto, CreatorDto dto, HttpSession session) {
		logger.info("UPDATE");
		System.out.println("UPDATE");
		System.out.println("mdto : " + mdto);
		System.out.println("dto : " + dto);
		
		int res = c_biz.mupdate(mdto);
		int cres = c_biz.update(dto);
		
		session.invalidate();
		return "redirect:loginForm.do";
	}
}
