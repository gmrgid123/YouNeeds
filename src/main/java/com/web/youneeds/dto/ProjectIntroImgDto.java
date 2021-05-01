package com.web.youneeds.dto;

public class ProjectIntroImgDto {
	private int intro_img_id;
	private String intro_origin_name;
	private String intro_stored_name;
	private String intro_stored_path;
	private int img_file_size;
	private int p_id;
	
	public ProjectIntroImgDto() {
		super();
	}

	public int getIntro_img_id() {
		return intro_img_id;
	}

	public void setIntro_img_id(int intro_img_id) {
		this.intro_img_id = intro_img_id;
	}

	public String getIntro_origin_name() {
		return intro_origin_name;
	}

	public void setIntro_origin_name(String intro_origin_name) {
		this.intro_origin_name = intro_origin_name;
	}

	public String getIntro_stored_name() {
		return intro_stored_name;
	}

	public void setIntro_stored_name(String intro_stored_name) {
		this.intro_stored_name = intro_stored_name;
	}

	public String getIntro_stored_path() {
		return intro_stored_path;
	}

	public void setIntro_stored_path(String intro_stored_path) {
		this.intro_stored_path = intro_stored_path;
	}

	public int getImg_file_size() {
		return img_file_size;
	}

	public void setImg_file_size(int img_file_size) {
		this.img_file_size = img_file_size;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	
	
}
