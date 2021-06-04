package com.web.youneeds.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.web.youneeds.biz.interf.QnaReplyBiz;
import com.web.youneeds.dto.MemberDto;
import com.web.youneeds.dto.QnaDto;
import com.web.youneeds.dto.QnaReplyDto;

@Controller
public class QnaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(QnaBoardController.class);
	
	@Autowired
	QnaBiz qnaBiz;
	
	@Autowired
	QnaReplyBiz replyBiz;
	
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
		//System.out.println(m_uid);
		//System.out.println(qna_title);
		//System.out.println(qna_content);
		
		
		QnaDto dto = new QnaDto();
		dto.setM_uid(m_uid); dto.setQna_title(qna_title); dto.setQna_content(qna_content);
		
		int no = qnaBiz.insert(dto);

		
		return "redirect:qnaView?no="+no;
	}
	
	
	@RequestMapping("/qnaUpdateForm")
	public String UpdateQnaForm(Model model, int ㅜㅐ) {
		return "";
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
