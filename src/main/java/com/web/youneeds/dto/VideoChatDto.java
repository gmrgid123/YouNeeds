package com.web.youneeds.dto;

import java.util.Date;

public class VideoChatDto {
	private int chat_id;
	private String chat_url;
	private String chat_toggle;
	private Date chat_regdate;
	private Date chat_deldate;
	private int p_id;
	
	public VideoChatDto() {
		super();
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public String getChat_url() {
		return chat_url;
	}

	public void setChat_url(String chat_url) {
		this.chat_url = chat_url;
	}

	public String getChat_toggle() {
		return chat_toggle;
	}

	public void setChat_toggle(String chat_toggle) {
		this.chat_toggle = chat_toggle;
	}

	public Date getChat_regdate() {
		return chat_regdate;
	}

	public void setChat_regdate(Date chat_regdate) {
		this.chat_regdate = chat_regdate;
	}

	public Date getChat_deldate() {
		return chat_deldate;
	}

	public void setChat_deldate(Date chat_deldate) {
		this.chat_deldate = chat_deldate;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
	
	
}
