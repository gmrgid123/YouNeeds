package com.web.youneeds.dto;

public class NoticeImgDto {
	private int notice_img_id;
	private String origin_name;
	private String stored_name;
	private String stored_path;
	private int file_size;
	private int notice_id;
	
	public NoticeImgDto() {
		super();
	}

	public int getNotice_img_id() {
		return notice_img_id;
	}

	public void setNotice_img_id(int notice_img_id) {
		this.notice_img_id = notice_img_id;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getStored_name() {
		return stored_name;
	}

	public void setStored_name(String stored_name) {
		this.stored_name = stored_name;
	}

	public String getStored_path() {
		return stored_path;
	}

	public void setStored_path(String stored_path) {
		this.stored_path = stored_path;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	
	
	
	
}
