package com.web.youneeds.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
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
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.NoticeDto;

@Controller
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@RequestMapping("/notice_board")
	public String noticeList(Model model, int p) {
		logger.info("공지사항 게시판 목록 페이지 호출");
		
		List<NoticeDto> list = noticeBiz.selectList(p);
		
		int list_max = noticeBiz.selectListMaxLength();
		System.out.println(list_max);
		int max;
		if(list_max%10 == 0) {
			max = list_max/10;
		}else {
			max = list_max/10 + 1;
		}
		
		int tmp=0;
		if((p%10)==0){
			tmp = p/10;
		}else{
			tmp = p/10 + 1;
		}
		int end_num = tmp*10;
		int start_num = end_num-9;
		
		model.addAttribute("list",list);
		model.addAttribute("list_max", list_max);
		model.addAttribute("max",max);
		model.addAttribute("start_num",start_num);
		model.addAttribute("end_num",end_num);
		model.addAttribute("page",p);
		
		return "/notice/NoticeList";
	}
	
	@RequestMapping("/notice_write")
	public String noticeWriteForm() {
		logger.info("공지사항 작성 페이지 호출");
		
		return "/notice/NoticeWrite";
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
						String uploadPath = request.getServletContext().getRealPath("/uploadImg/notice");
						
						
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
						String fileUrl = request.getContextPath() + "/uploadImg/notice/" + storedName;
						
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
	public String InsertNotice(HttpServletRequest request, String notice_title, String p_content) {
		logger.info("공지사항 업로드 처리");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("login")).getM_uid();
		
		NoticeDto dto = new NoticeDto();
		dto.setNotice_title(notice_title); dto.setNotice_content(p_content); dto.setM_uid(m_uid);
		
		int no = noticeBiz.insert(dto);
		System.out.println("notice_id값 : "  + no);
		
		return "redirect:noticeView?no="+no;
	}
	
	@RequestMapping("/noticeView")
	public String noticeDetailView(Model model, int no) {
		logger.info("공지사항 상세 호출");
		
		System.out.println("공지사항 번호 : "+no);
		
		NoticeDto dto = noticeBiz.selectOne(no);
		
		model.addAttribute("noticeDto", dto);
		
		return "/notice/NoticeView";
	}
	
	
}
