package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectDto;

public interface ProjectDao {
	public List<ProjectDto> selectList(ProjectDto dto);
	public ProjectDto selectOne(int p_id);
	public int insert(ProjectDto dto);
	public int update(ProjectDto dto);
	public int delete(int p_id);
}
