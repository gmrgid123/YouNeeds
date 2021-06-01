package com.web.youneeds.dao.interf;

import java.util.Map;

import com.web.youneeds.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE = "member.";
	
	public MemberDto selectOne(int m_uid); // 회원조회
	public int insert(MemberDto dto); // 회원가입
	public int update(MemberDto dto); // 정보수정
	public int withdrawal(int m_uid); // 회원탈퇴
	
	public MemberDto login(MemberDto dto) throws Exception; //로그인
	public int nicknameChk(MemberDto dto) throws Exception; // 닉네임 중복 검사
	public MemberDto findPwd(MemberDto dto) throws Exception; //비번찾기
}
