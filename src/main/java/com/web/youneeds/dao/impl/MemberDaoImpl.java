package com.web.youneeds.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.MemberDao;
import com.web.youneeds.dto.MemberDto;

import oracle.jdbc.proxy.annotation.Post;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberDto selectOne(int m_uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insert(MemberDto dto) {
		int res = 0;
		
		try {
			res=sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			System.out.println("error:insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdrawal(int m_uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nicknameChk(MemberDto dto) throws Exception{		// 닉네임 중복 검사
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"nicknameChk", dto);
		} catch (Exception e) {
			System.out.println("error:nicknameChk");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		MemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login", dto);
		} catch (Exception e) {
			System.out.println("error:login");
			e.printStackTrace();
		}
		return res;
	}

}
