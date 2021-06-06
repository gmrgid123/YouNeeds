package com.web.youneeds.biz.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dao.interf.MemberDao;
import com.web.youneeds.dto.MemberDto;

@Transactional
@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int insert(MemberDto dto) {
		return memberDao.insert(dto);
	}

	@Override
	public int update(MemberDto dto) {
		return memberDao.update(dto);
	}

	@Override
	public int withdrawal(int m_uid) {
		return memberDao.withdrawal(m_uid);
	}

	@Override
	public int nicknameChk(MemberDto dto) throws Exception {
		return memberDao.nicknameChk(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		return memberDao.login(dto);
	}

	@Override
	public MemberDto findPwd(MemberDto dto) throws Exception {
		return memberDao.findPwd(dto);
	}


}
