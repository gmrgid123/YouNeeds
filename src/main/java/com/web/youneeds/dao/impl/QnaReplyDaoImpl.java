package com.web.youneeds.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.QnaReplyDao;
import com.web.youneeds.dto.QnaReplyDto;

@Repository
public class QnaReplyDaoImpl implements QnaReplyDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<QnaReplyDto> selectList(Map<String, Integer> map) {
		List<QnaReplyDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList", map);
		} catch (Exception e) {
			System.out.println("[error] : QnaReplyDao - selectList");
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public int insert(QnaReplyDto dto) {
		int res=0;
		
		try {
			res=sqlSession.insert(NAMESPACE+"insertReply" ,dto);
		} catch (Exception e) {
			System.out.println("[error] : QnaReplyDao - insertReply");
			e.printStackTrace();
		}
		
		return res;
	}


	@Override
	public Integer selectListMaxLength(int qna_id) {
		Integer max = null;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength", qna_id);
		} catch (Exception e) {
			System.out.println("[error] : QnaReplyDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		return max;
	}

}
