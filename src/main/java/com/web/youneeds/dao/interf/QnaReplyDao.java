package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.QnaReplyDto;

public interface QnaReplyDao {
	String NAMESPACE = "qnaReplySql.";
	
	public List<QnaReplyDto> selectList(Map<String, Integer> map);
	public int insert(QnaReplyDto dto);
	public Integer selectListMaxLength(int qna_id);
}
