package com.web.youneeds.dto;

public class ProjectDto {

	private int p_id;
	private String p_title;
	private String p_category;
	private int target_amount;
	private String p_regdate;
	private String start_date;
	private String end_date;
	private int creator_uid;
	
	//join용 필드
	private CreatorDto creatorDto;
	private ProjectTitleImgDto projectTilteImgDto;
	private ProjectIntroDto projectIntroDto;
	private ProjectFundGuideDto projectFundGuideDto;
	
	
	
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



	public String getP_regdate() {
		return p_regdate;
	}



	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}



	public String getStart_date() {
		return start_date;
	}



	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	public String getEnd_date() {
		return end_date;
	}



	public void setEnd_date(String end_date) {
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



	public ProjectIntroDto getProjectIntroDto() {
		return projectIntroDto;
	}



	public void setProjectIntroDto(ProjectIntroDto projectIntroDto) {
		this.projectIntroDto = projectIntroDto;
	}



	public ProjectFundGuideDto getProjectFundGuideDto() {
		return projectFundGuideDto;
	}



	public void setProjectFundGuideDto(ProjectFundGuideDto projectFundGuideDto) {
		this.projectFundGuideDto = projectFundGuideDto;
	}


	

	public ProjectDto() {
		super();
	}
	
	



	public ProjectDto(int p_id, String p_title, String p_category, int target_amount, String p_regdate,
			String start_date, String end_date, int creator_uid, CreatorDto creatorDto,
			ProjectTitleImgDto projectTilteImgDto, ProjectIntroDto projectIntroDto,
			ProjectFundGuideDto projectFundGuideDto) {
		super();
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_category = p_category;
		this.target_amount = target_amount;
		this.p_regdate = p_regdate;
		this.start_date = start_date;
		this.end_date = end_date;
		this.creator_uid = creator_uid;
		this.creatorDto = creatorDto;
		this.projectTilteImgDto = projectTilteImgDto;
		this.projectIntroDto = projectIntroDto;
		this.projectFundGuideDto = projectFundGuideDto;
	}



	@Override
	public String toString() {
		return "ProjectDto [p_id=" + p_id + ", p_title=" + p_title + ", p_category=" + p_category + ", target_amount="
				+ target_amount + ", p_regdate=" + p_regdate + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", creator_uid=" + creator_uid + ", creatorDto=" + creatorDto + ", projectTilteImgDto="
				+ projectTilteImgDto + ", projectIntroDto=" + projectIntroDto + ", projectFundGuideDto="
				+ projectFundGuideDto + "]";
	}
	
	
	
	
	
}
