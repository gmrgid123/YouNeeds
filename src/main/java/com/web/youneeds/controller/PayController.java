package com.web.youneeds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/order_test")
	public String orderPayForm() {
		logger.info("펀딩 결제 페이지 호출");
		
		return "/order/OrderPay";
	}
	
}
