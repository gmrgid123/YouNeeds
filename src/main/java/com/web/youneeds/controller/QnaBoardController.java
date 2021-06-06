package com.web.youneeds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.web.youneeds.biz.interf.QnaBiz;
import com.web.youneeds.biz.interf.QnaReplyBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.QnaDto;
import com.web.youneeds.dto.QnaReplyDto;
import com.web.youneeds.service.EditorImgUploadService;

@Controller
public class QnaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(QnaBoardController.class);
	
	@Autowired
	QnaBiz qnaBiz;
	
	@Autowired
	QnaReplyBiz replyBiz;
	
	@Autowired
	private EditorImgUploadService editorService;
	
	
	@RequestMapping("/qna_board")
	public String qnaList(Model model, int p) {
		logger.info("QNA 게시판 목록 페이지 호출");
		
		List<QnaDto> list = qnaBiz.selectList(p);
		
		int list_max = qnaBiz.selectListMaxLength();

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
		model.addAttribute("max",max);
		model.addAttribute("start_num",start_num);
		model.addAttribute("end_num",end_num);
		model.addAttribute("page",p);
		
		return "/qna/QnaList";
	}
	
	@RequestMapping("/qna_write")
	public String qnaWriteForm() {
		logger.info("QNA 작성 페이지 호출");
		
		return "/qna/QnaWrite";
	}
	
	@RequestMapping("/qnaView")
	public String qnaDetailView(Model model, int no, Integer rp) {
		logger.info("QNA 상세 호출");
		
		int rp_val;
		
		if(rp == null) {
			rp_val = 0;
		} else {
			rp_val = rp.intValue();
		}
		
		
				
		if(qnaBiz.HitUpdate(no)>0) {
			QnaDto dto = qnaBiz.selectOne(no);
			List<QnaReplyDto> replyList = null;
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			int rp_ListMax = replyBiz.selectListMaxLength(no);
			int rp_max;
			int end_num;
			int start_num;
			int tmp;
			
			if(rp_ListMax%20 == 0) {
				rp_max = rp_ListMax/20;
			} else {
				rp_max = rp_ListMax/20 + 1;
			}
			
			if(rp_val != 0) {
				if((rp_val%10)==0){
					tmp = rp_val/10;
				}else{
					tmp = rp_val/10 + 1;
				}
				end_num = tmp*10;
				start_num = end_num-9;
				map.put("rp_val", rp_val);
				map.put("qna_id", no);
				
				replyList = replyBiz.selectList(map);
			} else {
				rp_val = rp_max;
				
				if((rp_val%10)==0){
					tmp = rp_val/10;
				}else{
					tmp = rp_val/10 + 1;
				}
				end_num = tmp*10;
				start_num = end_num-9;
				
				map.put("rp_val", rp_val);
				map.put("qna_id", no);
				
				replyList = replyBiz.selectList(map);
			}
			
			
			
			model.addAttribute("qnaDto", dto);
			model.addAttribute("replyList", replyList);
			model.addAttribute("rp_ListMax", rp_ListMax);
			model.addAttribute("rp_max",rp_max);
			model.addAttribute("start_num", start_num);
			model.addAttribute("end_num",end_num);
			model.addAttribute("reply_page", rp_val);
			
			
		}
		
		
		return "/qna/QnaView";
	}
	
	@RequestMapping(value="/qnaInsert.do",  method = RequestMethod.POST)
	public String InsertQna(HttpServletRequest request, String qna_title, String qna_content) {
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		
		logger.info("QNA 업로드 처리");
		
		
		QnaDto dto = new QnaDto();
		dto.setM_uid(m_uid); dto.setQna_title(qna_title); dto.setQna_content(qna_content);
		
		int no = qnaBiz.insert(dto);

		
		return "redirect:qnaView?no="+no;
	}
	
	
	@RequestMapping("/qnaUpdateForm")
	public String UpdateQnaForm(HttpServletRequest request, Model model, int no) {
		logger.info("QNA 업데이트 페이지 호출");
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		
		QnaDto dto = qnaBiz.selectOne(no);
		
		if(m_uid != dto.getM_uid()) {
			model.addAttribute("msg","작성자 계정이 아닙니다.");
			model.addAttribute("pageUrl", "qnaView?no="+dto.getQna_id());
			return "/form/warning";
		} else {
			model.addAttribute("dto",dto);
			return "/qna/QnaUpdate";
		}
	
	}
	
	@RequestMapping(value="/qnaUpdate.do", method = RequestMethod.POST)
	public String UpdateQnaDo(HttpServletRequest request, Model model, QnaDto dto) {
		logger.info("QNA 업데이트 처리");
		
		System.out.println(dto);
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		int writer_uid = qnaBiz.selectWriter(dto.getQna_id());
		
		if(m_uid == writer_uid) {
			if(qnaBiz.update(dto) > 0) {
				return "redirect:qnaView?no="+dto.getQna_id();
			} else {
				model.addAttribute("msg","QNA 수정에 실패했습니다.");
				model.addAttribute("pageUrl", "qnaView?no="+dto.getQna_id());
				return "/form/warning";
			}
		} else {
			model.addAttribute("msg","작성자 계정이 아닙니다.");
			model.addAttribute("pageUrl", "qnaView?no="+dto.getQna_id());
			return "/form/warning";
		}
		
	}
	
	@RequestMapping("/qnaDelete.do")
	public String DeleteQna(Model model, int no) {
		logger.info("QNA 삭제 처리");
		
		if(qnaBiz.delete(no) > 0) {
			return "redirect:qna_board?p=1";
		} else {
			model.addAttribute("msg","QNA 삭제에 실패했습니다.");
			model.addAttribute("pageUrl", "qnaView?no="+no);
			return "/form/warning";
		}
		
	}
	
	
	
	@RequestMapping(value="/qnaReplyInsert.do",method = RequestMethod.POST)
	public String ReplyInsert(HttpServletRequest request, String reply_content, int qna_id) {
		logger.info("QNA 댓글 업로드 처리");
		
		int m_uid = ((MemberDto)request.getSession().getAttribute("member")).getM_uid();
		
		QnaReplyDto dto = new QnaReplyDto();
		dto.setM_uid(m_uid); dto.setReply_content(reply_content);dto.setQna_id(qna_id);
		
		replyBiz.insert(dto);
		
		
		return "redirect:qnaView?no="+qna_id;
	}
	
	
	
	
	
	@RequestMapping(value="/uploadImg/qna", method = RequestMethod.POST)
	public void UploadImg(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) {
		logger.info("QNA 이미지 업로드 처리");
		
		String path = "/uploadImg/qna";
		editorService.ImgUpload(request, response, upload, path);
	}
	
}
