package com.web.youneeds.dao.impl;

import java.util.List;

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
	public List<QnaReplyDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QnaReplyDto selectOne(int qna_reply_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QnaReplyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QnaReplyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int qna_reply_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectListMaxLength() {
		int max=0;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength");
		} catch (Exception e) {
			System.out.println("[error] : QnaReplyDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		return max;
	}

}
