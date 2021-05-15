package com.web.youneeds.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.web.youneeds.biz.interf.NoticeBiz;
import com.web.youneeds.biz.interf.NoticeImgBiz;
import com.web.youneeds.dto.NoticeDto;

@Controller
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeBiz noticeBiz;
	
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
	
	
	@RequestMapping(value="/uploadImg/notice", method = RequestMethod.POST)
	public void UploadImg(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("이미지 업로드 처리");
		
		JsonObject json = new JsonObject();
		OutputStream out = null;
		PrintWriter printWriter = null;
		//랜덤 문자 생성
		UUID uuid = UUID.randomUUID();
		
		if(upload != null) {
			if(upload.getSize() > 0 && StringUtils.isNotBlank(upload.getName())) {
				if(upload.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						String originName = upload.getOriginalFilename();
						byte[] bytes = upload.getBytes();
						String uploadPath = request.getServletContext().getRealPath("/uploadImg");
						
						
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						String storedName = uuid + "_" + originName;
						out = new FileOutputStream(new File(uploadPath+"/"+storedName));
						out.write(bytes);
						out.flush();
						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + "/uploadImg/" + storedName;
						
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", storedName);
						json.addProperty("url", fileUrl);
						
						printWriter.println(json);
						printWriter.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						
						try {
							out.close();
							printWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	@RequestMapping(value="/noticeInsert.do",  method = RequestMethod.POST)
	public String InsertNotice(String notice_title, String p_content, int m_uid) {
		
		NoticeDto dto = new NoticeDto();
		dto.setNotice_title(notice_title); dto.setNotice_content(p_content); dto.setM_uid(m_uid);
		
		int no = noticeBiz.insert(dto);
		
		return "redirect:noticeView?no="+no;
	}
	
	@RequestMapping("/noticeView")
	public String noticeDetailView(Model model, int no) {
		
		NoticeDto dto = noticeBiz.selectOne(no);
		
		model.addAttribute("noticeDto", dto);
		
		return "/notice/NoticeView";
	}
	
	
}
