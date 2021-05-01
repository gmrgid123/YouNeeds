package com.web.youneeds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/qna_board")
	public String qnaList() {
		logger.info("QNA 게시판 목록 페이지 호출");
		
		return "/qna/QnaList";
	}
	
	@RequestMapping("/qna_write")
	public String qnaWriteForm() {
		logger.info("QNA 작성 페이지 호출");
		
		return "/qna/QnaWrite";
	}
	
	@RequestMapping("/qna_view")
	public String qnaView() {
		logger.info("QNA 상세 페이지 호출");
		
		return "/qna/QnaView";
	}
	
}
