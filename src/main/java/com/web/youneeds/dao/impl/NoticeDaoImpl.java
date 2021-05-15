package com.web.youneeds.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.NoticeDao;
import com.web.youneeds.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDto selectOne(int notice_id) {
		NoticeDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne", notice_id);
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - selectOne");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(NoticeDto dto) {
		
		try {
			sqlSession.insert(NAMESPACE+"noticeInsert",dto);
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - insert");
			e.printStackTrace();
		}
		
		return dto.getM_uid();
	}

	@Override
	public int update(NoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int notice_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
