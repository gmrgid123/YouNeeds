package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectFundGuideDto;

public interface ProjectFundGuideBiz {

	public List<ProjectFundGuideDto> selectList();
	public ProjectFundGuideDto selectOne(int p_id);
	public int insert(ProjectFundGuideDto dto);
	public int update(ProjectFundGuideDto dto);
	public int delete(int p_id);
	
}
