package com.web.youneeds.dto;

import java.util.Date;

public class NoticeDto {
	private int notice_id;
	private String notice_title;
	private String notice_content;
	private Date notice_regdate;
	private int m_uid;
	
	//Join¿ë ÇÊµå
	private MemberDto memberDto;
	
	
	public NoticeDto() {
		super();
	}


	public int getNotice_id() {
		return notice_id;
	}


	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}


	public String getNotice_title() {
		return notice_title;
	}


	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}


	public String getNotice_content() {
		return notice_content;
	}


	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}


	public Date getNotice_regdate() {
		return notice_regdate;
	}


	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
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
