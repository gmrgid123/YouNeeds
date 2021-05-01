package com.web.youneeds.dto;

import java.util.Date;

public class ProjectNoticeDto {
	private int p_notice_no;
	private int p_id;
	private String p_notice_title;
	private String p_notice_content;
	private Date p_notice_regdate;
	
	//join용 필드
	private ProjectDto projectDto;
	
	public ProjectNoticeDto() {
		super();
	}

	public int getP_notice_no() {
		return p_notice_no;
	}

	public void setP_notice_no(int p_notice_no) {
		this.p_notice_no = p_notice_no;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_notice_title() {
		return p_notice_title;
	}

	public void setP_notice_title(String p_notice_title) {
		this.p_notice_title = p_notice_title;
	}

	public String getP_notice_content() {
		return p_notice_content;
	}

	public void setP_notice_content(String p_notice_content) {
		this.p_notice_content = p_notice_content;
	}

	public Date getP_notice_regdate() {
		return p_notice_regdate;
	}

	public void setP_notice_regdate(Date p_notice_regdate) {
		this.p_notice_regdate = p_notice_regdate;
	}

	public ProjectDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}
	
	
	
	
	
}
