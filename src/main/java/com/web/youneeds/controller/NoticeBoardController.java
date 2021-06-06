package com.web.youneeds.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.youneeds.biz.interf.NoticeBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.NoticeDto;
import com.web.youneeds.service.EditorImgUploadService;

@Controller
public class NoticeBoardController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@Autowired
	private EditorImgUploadService editorService;
	
	@RequestMapping("/notice_board")
	public String noticeList(Model model, int p) {
		logger.info("공지사항 게시판 목록 페이지 호출");
		
		List<NoticeDto> list = noticeBiz.selectList(p);
		
		int list_max = noticeBiz.selectListMaxLength();
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
		
		String path = "/uploadImg/notice";
		editorService.ImgUpload(request, response, upload, path);
	}
	
	@RequestMapping(value="/noticeInsert.do",  method = RequestMethod.POST)
	public String InsertNotice(HttpServletRequest request, String notice_title, String p_content) {
		logger.info("공지사항 업로드 처리");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		
		NoticeDto dto = new NoticeDto();
		dto.setNotice_title(notice_title); dto.setNotice_content(p_content); dto.setM_uid(m_uid);
		
		int no = noticeBiz.insert(dto);
		System.out.println("notice_id값 : "  + no);
		
		return "redirect:noticeView?no="+no;
	}
	
	@RequestMapping("/noticeUpdateForm")
	public String UpdateFormNotice(Model model, int no) {
		logger.info("공지사항 업데이트 페이지 호출");
		
		NoticeDto dto = noticeBiz.selectOne(no);
		
		model.addAttribute("dto", dto);
		
		return "/notice/NoticeUpdate";
	}
	
	@RequestMapping(value="/noticeUpdate.do", method = RequestMethod.POST)
	public String UpdateNotice(Model model, NoticeDto dto) {
		logger.info("공지사항 업데이트 처리");
		
		
		if(noticeBiz.update(dto)>0) {
			return "redirect:noticeView?no="+dto.getNotice_id();
		} else {
			model.addAttribute("msg","공지사항 수정에 실패했습니다.");
			model.addAttribute("pageUrl", "noticeView?no="+dto.getNotice_id());
			return "/form/warning";
		}
	}
	
	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(Model model, int no) {
		logger.info("공지사항 삭제 처리");
		
		if(noticeBiz.delete(no)>0) {
			return "redirect:notice_board?p=1";
		}else {
			model.addAttribute("msg","공지사항 삭제에 실패했습니다.");
			model.addAttribute("pageUrl", "noticeView?no="+no);
			
			return "/form/warning";
		}
		
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
