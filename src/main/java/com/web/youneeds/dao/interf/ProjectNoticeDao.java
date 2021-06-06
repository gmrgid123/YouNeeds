package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.ProjectNoticeDto;

public interface ProjectNoticeDao {
	String NAMESPACE = "projectNoticeSql.";
	
	public List<ProjectNoticeDto> selectList(Map<String, Integer> map);
	public ProjectNoticeDto selectOne(Map<String, Integer> map);
	public int selectPjNoticeMaxLength(int p_id);
	public int insert(ProjectNoticeDto dto);
	public int update(ProjectNoticeDto dto);
	public int delete(int p_notice_no, int p_id);
}
