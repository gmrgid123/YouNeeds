package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectDto;

public interface ProjectBiz {

	public List<ProjectDto> selectList(ProjectDto dto);
	public ProjectDto selectOne(int p_id);
	public int insert(ProjectDto dto);
	public int update(ProjectDto dto);
	public int delete(int p_id);
	
	
}
