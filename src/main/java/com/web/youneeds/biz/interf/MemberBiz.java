package com.web.youneeds.biz.interf;

import com.web.youneeds.dto.MemberDto;

public interface MemberBiz {

	public int insert(MemberDto dto); //회원가입
	public int update(MemberDto dto);
	public int withdrawal(int m_uid);
	
	public MemberDto selectOne(int m_uid);
	public MemberDto login(MemberDto dto) throws Exception; 
	public int nicknameChk(MemberDto dto) throws Exception;
	public MemberDto findPwd(MemberDto dto) throws Exception; //비번찾기
}
