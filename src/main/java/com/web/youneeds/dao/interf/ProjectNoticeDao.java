package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.ProjectNoticeDto;

public interface ProjectNoticeDao {
	String NAMESPACE = "";
	
	public List<ProjectNoticeDto> selectList();
	public ProjectNoticeDto selectOne(int p_notice_no, int p_id);
	public int insert(ProjectNoticeDto dto);
	public int update(ProjectNoticeDto dto);
	public int delete(int p_notice_no, int p_id);
}
