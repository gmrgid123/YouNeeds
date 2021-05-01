package com.web.youneeds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/notice_board")
	public String noticeList() {
		logger.info("공지사항 게시판 목록 페이지 호출");
		
		return "/notice/NoticeList";
	}
	
	@RequestMapping("/notice_write")
	public String noticeWriteForm() {
		logger.info("공지사항 작성 페이지 호출");
		
		return "/notice/NoticeWrite";
	}
	
	@RequestMapping("/notice_view")
	public String noticeView() {
		logger.info("공지사항 상세 페이지 호출");
		
		return "/notice/NoticeView";
	}
	
	
}
