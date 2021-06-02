package com.web.youneeds.biz.interf;

import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;

public interface CreatorBiz {

	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
	public int mupdate(MemberDto mdto);
	//public CreatorDto clogin(CreatorDto cdto) throws Exception;
}
