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
	public List<NoticeDto> selectList(int p) {
		List<NoticeDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList", p);
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - selectList");
			e.printStackTrace();
		}
		
		
		return list;
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
		
		return dto.getNotice_id();
	}

	@Override
	public int update(NoticeDto dto) {
		int res=0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateNotice", dto);
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - update");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int notice_id) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteNotice", notice_id);
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - delete");
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int selectListMaxLength() {
		int max = 0;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength");
		} catch (Exception e) {
			System.out.println("[error] : noticeDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		
		return max;
	}

}
