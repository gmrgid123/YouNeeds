package com.web.youneeds.dto;

public class ProjectFundGuideDto {
	private int p_id;
	private String fund_guide_content;
	
	//join용 필드
	private ProjectDto projectDto;
	
	

	public ProjectFundGuideDto() {
		super();
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getFund_guide_content() {
		return fund_guide_content;
	}

	public void setFund_guide_content(String fund_guide_content) {
		this.fund_guide_content = fund_guide_content;
	}

	public ProjectDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
	}
	
	
	
	
}
