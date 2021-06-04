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
	public List<QnaDto> selectList(int p) {
		List<QnaDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList",p);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - selectList");
			e.printStackTrace();
		}
		
		return list;
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
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateQna",dto);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - updateQna");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int qna_id) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteQna", qna_id);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - deleteQna");
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public Integer selectListMaxLength() {
		Integer max=null;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength");
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		return max;
	}

	@Override
	public int HitUpdate(int qna_id) {
		int res=0;
		
		try {
			res = sqlSession.update(NAMESPACE+"hitUpdate", qna_id);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - HitUpdate");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int selectWriter(int qna_id) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectWriter", qna_id);
		} catch (Exception e) {
			System.out.println("[error] : QnaDao - selectWriter");
			e.printStackTrace();
		}
		
		return res;
	}

	
	

}
