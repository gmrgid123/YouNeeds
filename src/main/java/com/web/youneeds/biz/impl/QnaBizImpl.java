package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.QnaBiz;
import com.web.youneeds.dao.interf.QnaDao;
import com.web.youneeds.dto.QnaDto;

@Service
public class QnaBizImpl implements QnaBiz {

	@Autowired
	private QnaDao qnaDao;
	
	@Override
	public List<QnaDto> selectList(int p) {
		return qnaDao.selectList(p);
	}

	@Override
	public QnaDto selectOne(int qna_id) {
		return qnaDao.selectOne(qna_id);
	}

	@Override
	public int insert(QnaDto dto) {
		return qnaDao.insert(dto);
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

	@Override
	public int selectListMaxLength() {
		return qnaDao.selectListMaxLength();
	}

	@Override
	public int HitUpdate(int qna_id) {
		return qnaDao.HitUpdate(qna_id);
	}

}
