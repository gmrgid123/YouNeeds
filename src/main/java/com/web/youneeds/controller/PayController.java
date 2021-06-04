package com.web.youneeds.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.dto.OrderDto;

@Controller
public class PayController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OrderBiz orderBiz;
	
	@RequestMapping("/orderPayForm")
	public String orderPayForm() {
		logger.info("펀딩 결제 페이지 호출");
		
		return "/order/OrderPay";
	}
	
	@RequestMapping(value="/OrderSuccess", method = RequestMethod.POST)
	public String PaySuccess(Model model, String order_name, int order_pay, String order_phone, String order_email, String order_addr1, String order_addr2, String order_date, String imp_uid) {
		logger.info("펀딩 결제 성공 알림 페이지 호출");
		
		String order_addr = order_addr1 + " " + order_addr2;
		
		OrderDto dto = new OrderDto(order_name, order_pay, order_phone, order_email, 
									order_addr, imp_uid, 1, 2);
		
		System.out.println(dto);
		
		int order_no = orderBiz.paying(dto);
		if(order_no>0) {
			model.addAttribute("order_no",order_no);
			return "/order/OrderResult";
		} else {
			return "redirect:main.do";
		}
	}
	
	@RequestMapping(value="payDetail_popup", method = RequestMethod.GET)
	public String resultDetail(Model model, int order_id) {
		OrderDto dto = orderBiz.selectDetail(order_id);
		
		model.addAttribute("dto",dto);
		
		return "/order/OrderResultDetail";
	}
	
	
}
