package com.web.youneeds.biz.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.QnaReplyDto;

public interface QnaReplyBiz {
	
	public List<QnaReplyDto> selectList(Map<String, Integer> map);
	public int insert(QnaReplyDto dto);
	public int selectListMaxLength(int qna_id);
	
}
