package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.QnaReplyDto;

public interface QnaReplyDao {
	String NAMESPACE = "";
	
	public List<QnaReplyDto> selectList();
	public QnaReplyDto selectOne(int qna_reply_id);
	public int insert(QnaReplyDto dto);
	public int update(QnaReplyDto dto);
	public int delete(int qna_reply_id);
}
