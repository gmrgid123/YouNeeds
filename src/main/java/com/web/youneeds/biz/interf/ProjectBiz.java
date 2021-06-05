package com.web.youneeds.biz.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.ProjectDto;

public interface ProjectBiz {

	public List<ProjectDto> selectList(ProjectDto dto);
	public ProjectDto selectDetailIntro(int p_id);
	public ProjectDto selectOne(int p_id);
	public ProjectDto selectProjectInform(int p_id);
	public int insert(ProjectDto dto);
	public int update(ProjectDto dto);
	public int delete(int p_id);
	public int sumOrder(int p_id);
	public int orderCount(int p_id);
	public List<ProjectDto> creatorMyPageInfo(Map<String, Integer> map);
	public int selectListMaxLength(int m_uid);
	
	
	
}
