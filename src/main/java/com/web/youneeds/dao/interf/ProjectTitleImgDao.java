package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectTitleImgDto;

public interface ProjectTitleImgDao {
	String NAMESPACE = "titleImgSql.";
	
	public ProjectTitleImgDto selectOne(int p_id);
	public int insert(ProjectTitleImgDto dto);
	public int update(ProjectTitleImgDto dto);
	public int delete(int p_id);
}
