package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.QnaDto;

public interface QnaBiz {
	
	public List<QnaDto> selectList();
	public QnaDto selectOne(int qna_id);
	public int insert(QnaDto dto);
	public int update(QnaDto dto);
	public int delete(int qna_id);
	
}
