package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectIntroDto;

public interface ProjectIntroDao {
	String NAMESPACE = "";
	
	public List<ProjectIntroDto> selectList();
	public ProjectIntroDto selectOne(int p_id);
	public int insert(ProjectIntroDto dto);
	public int update(ProjectIntroDto dto);
	public int delete(int p_id);
}
