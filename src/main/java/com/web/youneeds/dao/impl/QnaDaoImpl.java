package com.web.youneeds.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.QnaDao;
import com.web.youneeds.dto.QnaDto;

@Repository
public class QnaDaoImpl implements QnaDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QnaDto selectOne(int qna_id) {
		QnaDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne", qna_id);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - selectOne");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(QnaDto dto) {
		
		try {
			sqlSession.insert(NAMESPACE+"QnaInsert" , dto);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - QnaInsert");
			e.printStackTrace();
		}
		
		return dto.getQna_id();
	}

	@Override
	public int update(QnaDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int qna_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
