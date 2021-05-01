package com.web.youneeds.biz.interf;

import com.web.youneeds.dto.MemberDto;

public interface MemberBiz {

	public MemberDto selectOne(int m_uid); 
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int withdrawal(int m_uid);
	
}
