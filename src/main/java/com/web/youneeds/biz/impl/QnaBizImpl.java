package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.biz.interf.QnaBiz;
import com.web.youneeds.dao.interf.QnaDao;
import com.web.youneeds.dto.QnaDto;

@Transactional
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
		return qnaDao.update(dto);
	}

	@Override
	public int delete(int qna_id) {
		return qnaDao.delete(qna_id);
	}

	@Override
	public int selectListMaxLength() {
		Integer temp = qnaDao.selectListMaxLength();
		
		if(temp==null) {
			return 0;
		} else {
			return temp.intValue();
		}
		
	}

	@Override
	public int HitUpdate(int qna_id) {
		return qnaDao.HitUpdate(qna_id);
	}

	@Override
	public int selectWriter(int qna_id) {
		return qnaDao.selectWriter(qna_id);
	}

}
