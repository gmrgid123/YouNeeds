package com.web.youneeds.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.OrderDto;

@Controller
public class PayController {

	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	private OrderBiz orderBiz;
	
	@Autowired
	private MemberBiz memberBiz;
	
	@RequestMapping("/orderPayForm")
	public String orderPayForm(int p_id) {
		logger.info("펀딩 결제 페이지 호출");
		
		return "/order/OrderPay";
	}
	
	@RequestMapping(value="/OrderSuccess", method = RequestMethod.POST)
	public String PaySuccess(HttpServletRequest request, Model model, int p_id, String order_name, int order_pay, String order_phone, String order_email, String order_addr1, String order_addr2, String order_date, String imp_uid) {
		logger.info("펀딩 결제 시도, 성공 알림 페이지 호출");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		String order_addr = order_addr1 + " " + order_addr2;
		
		OrderDto dto = new OrderDto(order_name, order_pay, order_phone, order_email, 
									order_addr, imp_uid, p_id, m_uid);
		
		System.out.println(dto);
		
		int order_no = orderBiz.paying(dto);
		if(order_no>0) {
			model.addAttribute("order_no",order_no);
			return "/order/OrderResult";
		} else {
			return "redirect:main.do";
		}
	}
	
	@RequestMapping("/requestMyInform")
	public void reqeustMyInform(HttpServletRequest request, HttpServletResponse response, int m_uid) {
		logger.info("결제페이지 - 나의 정보 요청");
		
		int login_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		
		if(login_uid == m_uid) {
			MemberDto inform = memberBiz.selectOne(m_uid);
			
			String gson = new Gson().toJson(inform);
			System.out.println(gson);
			
			try {
				response.getWriter().write(gson);
			}catch (JsonIOException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/payDetail_popup", method = RequestMethod.GET)
	public String resultDetail(Model model, int order_id) {
		OrderDto dto = orderBiz.selectDetail(order_id);
		
		model.addAttribute("dto",dto);
		
		return "/order/OrderResultDetail";
	}
	
	
}
