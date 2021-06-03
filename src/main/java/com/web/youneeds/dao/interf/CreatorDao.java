package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.CreatorDto;

public interface CreatorDao {
	String NAMESPACE = "creator.";
	
	public List<CreatorDto> creatorPageInfo(int m_uid);
	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
	
	
}
