package com.web.youneeds.biz.interf;

import com.web.youneeds.dto.MemberDto;

public interface MemberBiz {

	public MemberDto selectOne(int m_uid); //회원조회
	public int insert(MemberDto dto); //회원가입
	public int update(MemberDto dto);
	public int withdrawal(int m_uid);
	
	public int nicknameChk(MemberDto dto) throws Exception;
}
