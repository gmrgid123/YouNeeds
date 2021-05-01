package com.web.youneeds.dto;

public class ProjectIntroDto {
	private int p_id;
	private String p_intro;
	
	//join용 필드
	private ProjectDto projectDto;

	public ProjectIntroDto() {
		super();
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_intro() {
		return p_intro;
	}

	public void setP_intro(String p_intro) {
		this.p_intro = p_intro;
	}

	public ProjectDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}
	
	
	
}
