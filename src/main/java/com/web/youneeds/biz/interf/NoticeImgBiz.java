package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.NoticeImgDto;

public interface NoticeImgBiz {

	public List<NoticeImgDto> selectList();
	public NoticeImgDto selectOne(int notice_img_id);
	public int insert(NoticeImgDto dto);
	public int update(NoticeImgDto dto);
	public int delete(int notice_img_id);
}
