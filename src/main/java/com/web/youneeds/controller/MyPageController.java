package com.web.youneeds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.OrderDto;
import com.web.youneeds.dto.ProjectDto;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OrderBiz orderBiz;
	@Autowired
	private ProjectBiz projectBiz;
	
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
	public String selectOne(Model model, HttpServletRequest request, HttpServletResponse response, Integer page) {
		logger.info("userMypage 호출");
		MemberDto dto = (MemberDto)request.getSession().getAttribute("member");
		
		int page_val;
		
		if(page == null) {
			page_val = 0;
		}else {
			page_val = page.intValue();
		}
		
		List<OrderDto> user = null;
		List<ProjectDto> creator = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int mypage_ListMax;
		int page_max;
		int end_num;
		int start_num;
		int tmp;
		
		//유저 마이페이지 정보
		if(dto.getM_type().equals("일반") || dto.getM_type().equals("관리")) {
			
			mypage_ListMax = orderBiz.selectListMaxLength(dto.getM_uid());
			
			if(mypage_ListMax%3 == 0) {
				page_max = mypage_ListMax/3;
			}else {
				page_max = mypage_ListMax/3 + 1;
			}
			
			if(page_val != 0) {
				if((page_val%5)==0){
					tmp = page_val/5;
				}else {
					tmp = page_val/5 + 1;
				}
				end_num = tmp*5;
				start_num = end_num - 4;
				map.put("page_val", page_val);
				map.put("m_uid", dto.getM_uid());
				
				user = orderBiz.userMyPageInfo(map);
			}else {
				page_val = page_max;
				
				if((page_val%5)==0) {
					tmp = page_val/5;
				}else {
					tmp = page_val/5 + 1;
				}
				end_num = tmp*5;
				start_num = end_num - 4;
				
				map.put("page_val", page_val);
				map.put("m_uid", dto.getM_uid());
				
				user = orderBiz.userMyPageInfo(map);
			}
			
			System.out.println(user);
			
			model.addAttribute("user", user);
			model.addAttribute("mypage_ListMax", mypage_ListMax);
			model.addAttribute("page_max", page_max);
			model.addAttribute("start_num", start_num);
			model.addAttribute("end_num", end_num);
			model.addAttribute("page_val", page_val);
			return "/mypage/userMypage";
		
		//창작자 마이페이지 정보
		} else {
			mypage_ListMax = projectBiz.selectListMaxLength(dto.getM_uid());
			
			if(mypage_ListMax%3 == 0) {
				page_max = mypage_ListMax/3;
			}else {
				page_max = mypage_ListMax/3 + 1;
			}
			
			if(page_val != 0) {
				if((page_val%5)==0){
					tmp = page_val/5;
				}else {
					tmp = page_val/5 + 1;
				}
				end_num = tmp*5;
				start_num = end_num - 4;
				map.put("page_val", page_val);
				map.put("m_uid", dto.getM_uid());
				
				creator = projectBiz.creatorMyPageInfo(map);
			}else {
				page_val = page_max;
				
				if((page_val%5)==0) {
					tmp = page_val/5;
				}else {
					tmp = page_val/5 + 1;
				}
				end_num = tmp*5;
				start_num = end_num - 4;
				
				map.put("page_val", page_val);
				map.put("m_uid", dto.getM_uid());
				
				creator = projectBiz.creatorMyPageInfo(map);
			}
			
			model.addAttribute("creator", creator);
			model.addAttribute("mypage_ListMax", mypage_ListMax);
			model.addAttribute("page_max", page_max);
			model.addAttribute("start_num", start_num);
			model.addAttribute("end_num", end_num);
			model.addAttribute("page_val", page_val);
			return "/mypage/creatorMypage";
		}
		
	}
	
}
