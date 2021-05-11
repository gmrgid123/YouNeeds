package com.web.youneeds.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dao.interf.MemberDao;
import com.web.youneeds.dto.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDto selectOne(int m_uid) {
		return null;
	}

	@Override
	public int insert(MemberDto dto) {
		return memberDao.insert(dto);
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
	public int nicknameChk(MemberDto dto) throws Exception {
		return memberDao.nicknameChk(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		return memberDao.login(dto);
	}

}
