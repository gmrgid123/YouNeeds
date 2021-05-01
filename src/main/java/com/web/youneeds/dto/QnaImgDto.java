package com.web.youneeds.dto;

public class QnaImgDto {
	private int qna_img_id;
	private String origin_name;
	private String stored_name;
	private String stored_path;
	private int file_size;
	private int qna_id;
	
	public QnaImgDto() {
		super();
	}

	public int getQna_img_id() {
		return qna_img_id;
	}

	public void setQna_img_id(int qna_img_id) {
		this.qna_img_id = qna_img_id;
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

	public int getQna_id() {
		return qna_id;
	}

	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	
	
	
	
}
