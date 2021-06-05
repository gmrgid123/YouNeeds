package com.web.youneeds.dto;

public class ProjectFundGuideDto {
	private int p_id;
	private String fund_guide_content;
	
	
	public ProjectFundGuideDto() {
		super();
	}
	
	public ProjectFundGuideDto(String fund_guide_content) {
		super();
		this.fund_guide_content = fund_guide_content;
	}

	public ProjectFundGuideDto(int p_id, String fund_guide_content) {
		super();
		this.p_id = p_id;
		this.fund_guide_content = fund_guide_content;
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

	@Override
	public String toString() {
		return "ProjectFundGuideDto [p_id=" + p_id + ", fund_guide_content=" + fund_guide_content + "]";
	}

	
	
	
}
