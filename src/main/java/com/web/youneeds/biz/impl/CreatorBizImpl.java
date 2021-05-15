package com.web.youneeds.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.CreatorBiz;
import com.web.youneeds.dao.interf.CreatorDao;
import com.web.youneeds.dto.CreatorDto;

@Service
public class CreatorBizImpl implements CreatorBiz {
	
	@Autowired
	private CreatorDao creatorDao;
	
	@Override
	public CreatorDto selectOne(int m_uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CreatorDto dto) {
		return creatorDao.insert(dto);
	}

	@Override
	public int update(CreatorDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
