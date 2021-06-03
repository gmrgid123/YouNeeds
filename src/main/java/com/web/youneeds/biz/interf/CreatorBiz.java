package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.CreatorDto;

public interface CreatorBiz {
	
	public List<CreatorDto> creatorPageInfo(int m_uid);	
	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
}
