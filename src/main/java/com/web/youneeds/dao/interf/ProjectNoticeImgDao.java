package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectNoticeImgDto;

public interface ProjectNoticeImgDao {
	String NAMESPACE = "";
	
	public List<ProjectNoticeImgDto> selectList();
	public ProjectNoticeImgDto selectOne(int p_notice_img_id);
	public int insert(ProjectNoticeImgDto dto);
	public int update(ProjectNoticeImgDto dto);
	public int delete(int p_notice_img_id);
}
