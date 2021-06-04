package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.ProjectDto;

public interface ProjectDao {
	String NAMESPACE = "projectSQL.";
	
	public List<ProjectDto> selectList(ProjectDto dto);
	public ProjectDto selectOne(int p_id);
	public int insert(ProjectDto dto);
	public int update(ProjectDto dto);
	public int delete(int p_id);
	public List<ProjectDto> creatorMyPageInfo(Map<String, Integer> map);
	public Integer selectListMaxLength(int m_uid);
}
