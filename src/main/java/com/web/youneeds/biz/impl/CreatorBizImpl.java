package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.CreatorBiz;
import com.web.youneeds.dao.interf.CreatorDao;
import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;

@Service
public class CreatorBizImpl implements CreatorBiz {
	
	@Autowired
	private CreatorDao creatorDao;
	
	@Override
	public List<CreatorDto> creatorPageInfo(int m_uid) {
		return creatorDao.creatorPageInfo(m_uid);
	}
	
	@Override
	public CreatorDto selectOne(int m_uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CreatorDto dto) {
		System.out.println("되라");
		return creatorDao.insert(dto);
	}

	@Override
	public int update(CreatorDto dto) {
		return creatorDao.update(dto);
	}

	@Override
	public int mupdate(MemberDto mdto) {
		return creatorDao.mupdate(mdto);
	}

	/*
	@Override
	public CreatorDto clogin(CreatorDto cdto) throws Exception{
		return creatorDao.clogin(cdto);
	}
	*/

}
