package com.web.youneeds.biz.impl;

import com.web.youneeds.biz.interf.MemberBiz;
import com.web.youneeds.dao.interf.MemberDao;
import com.web.youneeds.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {

	private MemberDao memberDao;
	
	@Override
	public MemberDto selectOne(int m_uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
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

}
