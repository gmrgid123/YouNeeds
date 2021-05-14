package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.NoticeDto;

public interface NoticeDao {
	String NAMESPACE = "NoticeSql.";
	
	public List<NoticeDto> selectList();
	public NoticeDto selectOne(int notice_id);
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int notice_id);
	
	
}
