package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.QnaImgDto;

public interface QnaImgDao {
	String NAMESPACE = "";
	
	public List<QnaImgDto> selectList();
	public QnaImgDto selectOne(int qna_img_id);
	public int insert(QnaImgDto dto);
	public int update(QnaImgDto dto);
	public int delete(int qna_img_id);
}
