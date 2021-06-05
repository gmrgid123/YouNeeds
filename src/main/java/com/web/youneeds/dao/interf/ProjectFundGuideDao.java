package com.web.youneeds.dao.interf;


import com.web.youneeds.dto.ProjectFundGuideDto;

public interface ProjectFundGuideDao {
	String NAMESPACE = "fundGuideSql.";
	
	public ProjectFundGuideDto selectOne(int p_id);
	public int insert(ProjectFundGuideDto dto);
	public int update(ProjectFundGuideDto dto);
	public int delete(int p_id);
}
