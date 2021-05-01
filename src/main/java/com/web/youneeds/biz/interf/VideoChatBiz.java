package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.VideoChatDto;

public interface VideoChatBiz {

	public List<VideoChatDto> selectList();
	public VideoChatDto selectOne(int chat_id);
	public int insert(VideoChatDto dto);
	public int update(VideoChatDto dto);
	public int delete(int chat_id);
	
}
