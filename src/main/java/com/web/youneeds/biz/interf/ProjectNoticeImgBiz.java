package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectNoticeImgDto;

public interface ProjectNoticeImgBiz {

	public List<ProjectNoticeImgDto> selectList();
	public ProjectNoticeImgDto selectOne(int p_notice_img_id);
	public int insert(ProjectNoticeImgDto dto);
	public int update(ProjectNoticeImgDto dto);
	public int delete(int p_notice_img_id);
	
}
