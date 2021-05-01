package com.web.youneeds.dto;

import java.util.Date;

public class MemberDto {
	private int m_uid;
	private String m_email;
	private String m_pw;
	private String m_nickname;
	private String m_addr;
	private String m_type;
	private Date m_regdate;
	private String m_enabled;
	private Date m_deldate;
	
	
	public MemberDto() {
		super();
	}


	public int getM_uid() {
		return m_uid;
	}


	public void setM_uid(int m_uid) {
		this.m_uid = m_uid;
	}


	public String getM_email() {
		return m_email;
	}


	public void setM_email(String m_email) {
		this.m_email = m_email;
	}


	public String getM_pw() {
		return m_pw;
	}


	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}


	public String getM_nickname() {
		return m_nickname;
	}


	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}


	public String getM_addr() {
		return m_addr;
	}


	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}


	public String getM_type() {
		return m_type;
	}


	public void setM_type(String m_type) {
		this.m_type = m_type;
	}


	public Date getM_regdate() {
		return m_regdate;
	}


	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}


	public String getM_enabled() {
		return m_enabled;
	}


	public void setM_enabled(String m_enabled) {
		this.m_enabled = m_enabled;
	}


	public Date getM_deldate() {
		return m_deldate;
	}


	public void setM_deldate(Date m_deldate) {
		this.m_deldate = m_deldate;
	}
	
	
	
	
	
}
