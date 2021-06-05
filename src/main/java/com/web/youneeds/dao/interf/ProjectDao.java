package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.ProjectDto;
import com.web.youneeds.dto.ProjectFundGuideDto;
import com.web.youneeds.dto.ProjectIntroDto;
import com.web.youneeds.dto.ProjectTitleImgDto;

public interface ProjectDao {
	String NAMESPACE = "projectSQL.";
	
	public List<ProjectDto> selectList(ProjectDto dto);
	public ProjectDto selectDetailIntro(int p_id);
	public ProjectDto selectProjectInform(int p_id);
	public ProjectDto selectOne(int p_id);
	public int insertProject(ProjectDto dto);
	public int insertIntro(ProjectIntroDto dto);
	public int insertImgTitle(ProjectTitleImgDto dto);
	public int insertGuide(ProjectFundGuideDto dto);
	public Integer sumOrder(int p_id);
	public Integer orderCount(int p_id);
	public int update(ProjectDto dto);
	public int delete(int p_id);
	public List<ProjectDto> creatorMyPageInfo(Map<String, Integer> map);
	public Integer selectListMaxLength(int m_uid);
}
