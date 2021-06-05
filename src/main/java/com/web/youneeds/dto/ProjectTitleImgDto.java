package com.web.youneeds.dto;

public class ProjectTitleImgDto {
	private int p_id;
	private String title_origin_name;
	private String title_stored_name;
	private String title_stored_path;
	private int title_file_size;
	
	
	
	
	public ProjectTitleImgDto() {
		super();
	}

	public ProjectTitleImgDto(String title_origin_name, String title_stored_name, String title_stored_path,
			int title_file_size) {
		super();
		this.title_origin_name = title_origin_name;
		this.title_stored_name = title_stored_name;
		this.title_stored_path = title_stored_path;
		this.title_file_size = title_file_size;
	}

	public ProjectTitleImgDto(int p_id, String title_origin_name, String title_stored_name, String title_stored_path,
			int title_file_size) {
		super();
		this.p_id = p_id;
		this.title_origin_name = title_origin_name;
		this.title_stored_name = title_stored_name;
		this.title_stored_path = title_stored_path;
		this.title_file_size = title_file_size;
	}

	

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getTitle_origin_name() {
		return title_origin_name;
	}

	public void setTitle_origin_name(String title_origin_name) {
		this.title_origin_name = title_origin_name;
	}

	public String getTitle_stored_name() {
		return title_stored_name;
	}

	public void setTitle_stored_name(String title_stored_name) {
		this.title_stored_name = title_stored_name;
	}

	public String getTitle_stored_path() {
		return title_stored_path;
	}

	public void setTitle_stored_path(String title_stored_path) {
		this.title_stored_path = title_stored_path;
	}

	public int getTitle_file_size() {
		return title_file_size;
	}

	public void setTitle_file_size(int title_file_size) {
		this.title_file_size = title_file_size;
	}

	@Override
	public String toString() {
		return "ProjectTitleImgDto [p_id=" + p_id + ", title_origin_name=" + title_origin_name + ", title_stored_name="
				+ title_stored_name + ", title_stored_path=" + title_stored_path + ", title_file_size="
				+ title_file_size + "]";
	}
	
	
	
}
