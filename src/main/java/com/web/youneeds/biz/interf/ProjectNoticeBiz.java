package com.web.youneeds.biz.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.ProjectNoticeDto;

public interface ProjectNoticeBiz {

	public List<ProjectNoticeDto> selectList(Map<String, Integer> map);
	public ProjectNoticeDto selectOne(Map<String, Integer> map);
	public int selectPjNoticeMaxLength(int p_id);
	public int insert(ProjectNoticeDto dto);
	
	
}
