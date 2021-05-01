package com.web.youneeds.dao.interf;

import com.web.youneeds.dto.CreatorDto;

public interface CreatorDao {
	String NAMESPACE = "";
	
	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
	
	
}
