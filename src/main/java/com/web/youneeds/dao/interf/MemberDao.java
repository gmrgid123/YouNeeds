package com.web.youneeds.dao.interf;

import com.web.youneeds.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "";
	
	public MemberDto selectOne(int m_uid); // 회원조회
	public int insert(MemberDto dto); // 회원가입
	public int update(MemberDto dto); // 정보수정
	public int withdrawal(int m_uid); // 회원탈퇴
	
	
}
