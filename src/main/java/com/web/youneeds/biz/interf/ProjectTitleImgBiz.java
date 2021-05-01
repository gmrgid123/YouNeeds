package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectTitleImgDto;

public interface ProjectTitleImgBiz {

	public List<ProjectTitleImgDto> selectList();
	public ProjectTitleImgDto selectOne(int p_id);
	public int insert(ProjectTitleImgDto dto);
	public int update(ProjectTitleImgDto dto);
	public int delete(int p_id);
	
}
