package com.web.youneeds.controller;


import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dto.MemberDto;

@Controller
public class EmailController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MemberBiz biz;

	/* 회원가입 메일 인증번호 */
	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증번호:"+email);
		
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		logger.info("인증번호"+checkNum);
		System.out.println("인증번호:"+checkNum);
		
		String setFrom = "kh2dooribun@gmail.com";
		String toMail = email;
		String title = "유니즈 회원가입 인증 이메일입니다.";
		String content = "유니즈 홈페이지를 방문해주셔서 감사합니다."+
						"<br><br>"+
						"인증번호는 "+checkNum+"입니다."+
						"<br>"+
						"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		String num = Integer.toString(checkNum);
		
		return num;
	}

	/* 비번찾기 메일 */
	@RequestMapping(value="/find_pass.do", method=RequestMethod.POST)
	public String findPwd(HttpServletRequest request, MemberDto dto, RedirectAttributes rttr) throws Exception {
		String m_email=request.getParameter("m_email");
		String m_pw=request.getParameter("m_pw");
		
		System.out.println("보낼 이메일:"+m_email);
		
		MemberDto findPwd = biz.findPwd(dto);
		
		if(findPwd == null) {
			System.out.println("일치하는 회원 정보가 없음");
			rttr.addFlashAttribute("msg", "fail");
			return "login/general_create";
		} else {
			System.out.println("일치하는 회원 정보 찾음");
			rttr.addFlashAttribute("msg", "success");
			
			String pwd = findPwd.getM_pw();
			String email = findPwd.getM_email();
			System.out.println("전송 비번"+pwd);
			
			String setFrom = "kh2dooribun@gmail.com";
			String to = m_email;
			String title = "유니즈 비밀번호를 알려드립니다.";
			String content = "안녕하세요. 유니즈입니다. "+
							"비밀번호는 "+pwd+"입니다.";
			
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom);
				helper.setTo(to);
				helper.setSubject(title);
				helper.setText(content);
				mailSender.send(message);
			
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		return "redirect:loginForm.do";
	}
}
