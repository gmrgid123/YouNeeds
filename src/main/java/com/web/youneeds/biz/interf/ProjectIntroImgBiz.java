package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectIntroImgDto;

public interface ProjectIntroImgBiz {

	public List<ProjectIntroImgDto> selectList();
	public ProjectIntroImgDto selectOne(int intro_img_id);
	public int insert(ProjectIntroImgDto dto);
	public int update(ProjectIntroImgDto dto);
	public int delete(int intro_img_id);
	
	
}
