package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.VideoChatBiz;
import com.web.youneeds.dao.interf.VideoChatDao;
import com.web.youneeds.dto.VideoChatDto;

@Service
public class VideoChatBizImpl implements VideoChatBiz {

	@Autowired
	private VideoChatDao videoChatDao;
	
	@Override
	public List<VideoChatDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoChatDto selectOne(int chat_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(VideoChatDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(VideoChatDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int chat_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
