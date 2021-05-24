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
import com.web.youneeds.biz.interf.QnaBiz;
import com.web.youneeds.dto.QnaDto;

@Controller
public class QnaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	QnaBiz qnaBiz;
	
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
	
	@RequestMapping("/qnaView")
	public String noticeDetailView(Model model, int no) {
		logger.info("QNA 상세 호출");
		
		System.out.println("QNA 번호 : "+no);
		
		QnaDto dto = qnaBiz.selectOne(no);
		System.out.println(dto);
		
		model.addAttribute("qnaDto", dto);
		
		return "/qna/QnaView";
	}
	
	@RequestMapping(value="/qnaInsert.do",  method = RequestMethod.POST)
	public String InsertNotice(String qna_title, String qna_content, int m_uid) {
		logger.info("QNA 업로드 처리");
		System.out.println(m_uid);
		System.out.println(qna_title);
		System.out.println(qna_content);
		
		
		QnaDto dto = new QnaDto();
		dto.setM_uid(m_uid); dto.setQna_title(qna_title); dto.setQna_content(qna_content);
		
		int no = qnaBiz.insert(dto);
		System.out.println("qna_id값 : "  + no);
		
		return "redirect:qnaView?no="+no;
	}
	
	
	@RequestMapping(value="/uploadImg/qna", method = RequestMethod.POST)
	public void UploadImg(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("QNA 이미지 업로드 처리");
		
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
						String uploadPath = request.getServletContext().getRealPath("/uploadImg/qna");
						
						
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
						String fileUrl = request.getContextPath() + "/uploadImg/qna/" + storedName;
						
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
	
}
