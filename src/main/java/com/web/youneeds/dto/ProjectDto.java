package com.web.youneeds.dto;

import java.util.Date;

public class ProjectDto {

	private int p_id;
	private String p_title;
	private String p_category;
	private int target_amount;
	private Date p_regdate;
	private Date start_date;
	private Date end_date;
	private int creator_uid;
	
	public int getP_id() {
		return p_id;
	}






	public void setP_id(int p_id) {
		this.p_id = p_id;
	}






	public String getP_title() {
		return p_title;
	}






	public void setP_title(String p_title) {
		this.p_title = p_title;
	}






	public String getP_category() {
		return p_category;
	}






	public void setP_category(String p_category) {
		this.p_category = p_category;
	}






	public int getTarget_amount() {
		return target_amount;
	}






	public void setTarget_amount(int target_amount) {
		this.target_amount = target_amount;
	}






	public Date getP_regdate() {
		return p_regdate;
	}






	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}






	public Date getStart_date() {
		return start_date;
	}






	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}






	public Date getEnd_date() {
		return end_date;
	}






	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}






	public int getCreator_uid() {
		return creator_uid;
	}






	public void setCreator_uid(int creator_uid) {
		this.creator_uid = creator_uid;
	}






	public CreatorDto getCreatorDto() {
		return creatorDto;
	}






	public void setCreatorDto(CreatorDto creatorDto) {
		this.creatorDto = creatorDto;
	}






	public ProjectTitleImgDto getProjectTilteImgDto() {
		return projectTilteImgDto;
	}






	public void setProjectTilteImgDto(ProjectTitleImgDto projectTilteImgDto) {
		this.projectTilteImgDto = projectTilteImgDto;
	}






	//join용 필드
	private CreatorDto creatorDto;
	private ProjectTitleImgDto projectTilteImgDto;
	
	
	public ProjectDto() {
		super();
	}


	
	


	@Override
	public String toString() {
		return "ProjectDto [p_id=" + p_id + ", p_title=" + p_title + ", p_category=" + p_category + ", target_amount="
				+ target_amount + ", p_regdate=" + p_regdate + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", creator_uid=" + creator_uid + ", creatorDto=" + creatorDto + ", projectTilteImgDto="
				+ projectTilteImgDto + "]";
	}
	
	
}
