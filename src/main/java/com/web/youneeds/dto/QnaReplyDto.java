package com.web.youneeds.dto;

import java.util.Date;

public class QnaReplyDto {
	private int qna_reply_id;
	private String qna_reply_content;
	private Date reply_regdate;
	private int qna_id;
	private int m_uid;
	
	//join용 필드
	private MemberDto memberDto;
	
	public QnaReplyDto() {
		super();
	}

	public int getQna_reply_id() {
		return qna_reply_id;
	}

	public void setQna_reply_id(int qna_reply_id) {
		this.qna_reply_id = qna_reply_id;
	}

	public String getQna_reply_content() {
		return qna_reply_content;
	}

	public void setQna_reply_content(String qna_reply_content) {
		this.qna_reply_content = qna_reply_content;
	}

	public Date getReply_regdate() {
		return reply_regdate;
	}

	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}

	public int getQna_id() {
		return qna_id;
	}

	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}

	public int getM_uid() {
		return m_uid;
	}

	public void setM_uid(int m_uid) {
		this.m_uid = m_uid;
	}

	public MemberDto getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	
	
	
}
