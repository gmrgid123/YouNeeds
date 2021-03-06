package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.QnaDto;

public interface QnaDao {
	String NAMESPACE = "QnaSql.";
	
	public List<QnaDto> selectList(int p);
	public QnaDto selectOne(int qna_id);
	public int insert(QnaDto dto);
	public int update(QnaDto dto);
	public int delete(int qna_id);
	public Integer selectListMaxLength();
	public int HitUpdate(int qna_id);
	public int selectWriter(int qna_id);
}
