package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.NoticeDto;

public interface NoticeBiz {

	public List<NoticeDto> selectList(int p);
	public NoticeDto selectOne(int notice_id);
	public int insert(NoticeDto dto);
	public int update(NoticeDto dto);
	public int delete(int notice_id);
	public int selectListMaxLength();
}
