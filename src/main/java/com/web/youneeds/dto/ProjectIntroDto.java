package com.web.youneeds.dto;

public class ProjectIntroDto {
	private int p_id;
	private String p_intro;
	
	

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
	
	
	

	public ProjectIntroDto() {
		super();
	}

	public ProjectIntroDto(String p_intro) {
		super();
		this.p_intro = p_intro;
	}

	public ProjectIntroDto(int p_id, String p_intro) {
		super();
		this.p_id = p_id;
		this.p_intro = p_intro;
	}

	@Override
	public String toString() {
		return "ProjectIntroDto [p_id=" + p_id + ", p_intro=" + p_intro + "]";
	}
	
	

	
}
