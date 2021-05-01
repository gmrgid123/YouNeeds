package com.web.youneeds.biz.interf;

import com.web.youneeds.dto.CreatorDto;

public interface CreatorBiz {

	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
}
