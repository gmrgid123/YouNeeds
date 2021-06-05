package com.web.youneeds.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.MemberDao;
import com.web.youneeds.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
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
		int res = 0;
				
				try {
					res = sqlSession.update(NAMESPACE+"update", dto);
					System.out.println("update");
				} catch (Exception e) {
					System.out.println("[error] : update");
					e.printStackTrace();
				}
				
				return res;
	}

	@Override
	public int withdrawal(int m_uid) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"withdrawal", m_uid);
			System.out.println("whithdrawal");
		} catch (Exception e) {
			System.out.println("[error] : whithdrawal");
			e.printStackTrace();
		}
		
		return res;
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

	@Override
	public MemberDto findPwd(MemberDto dto) throws Exception {
		MemberDto res = null;
				
				try {
					res = sqlSession.selectOne(NAMESPACE+"findPwd", dto);
				} catch (Exception e) {
					System.out.println("error:findPwd");
					e.printStackTrace();
				}
				return res;
			}


}
