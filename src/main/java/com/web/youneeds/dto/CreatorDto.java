package com.web.youneeds.dto;

public class CreatorDto {
	private int m_uid;
	private String create_name;
	private String create_intro;
	
	//join용 필드
	private MemberDto memberDto;
	
	public CreatorDto() {
		super();
	}

	public int getM_uid() {
		return m_uid;
	}

	public void setM_uid(int m_uid) {
		this.m_uid = m_uid;
	}

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	public String getCreate_intro() {
		return create_intro;
	}

	public void setCreate_intro(String create_intro) {
		this.create_intro = create_intro;
	}

	public MemberDto getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
	
	
	
	
}
