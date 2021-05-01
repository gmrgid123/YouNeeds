package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectIntroImgDto;

public interface ProjectIntroImgDao {
	String NAMESPACE = "";
	
	public List<ProjectIntroImgDto> selectList();
	public ProjectIntroImgDto selectOne(int intro_img_id);
	public int insert(ProjectIntroImgDto dto);
	public int update(ProjectIntroImgDto dto);
	public int delete(int intro_img_id);
}
