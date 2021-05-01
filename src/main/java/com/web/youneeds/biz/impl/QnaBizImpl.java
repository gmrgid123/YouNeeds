package com.web.youneeds.biz.impl;

import java.util.List;

import com.web.youneeds.biz.interf.QnaBiz;
import com.web.youneeds.dao.interf.QnaDao;
import com.web.youneeds.dto.QnaDto;

public class QnaBizImpl implements QnaBiz {

	private QnaDao qnaDao;
	
	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QnaDto selectOne(int qna_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QnaDto dto) {
		// TODO Auto-generated method stub
		return 0;
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
