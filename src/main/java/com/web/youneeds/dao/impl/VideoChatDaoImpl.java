package com.web.youneeds.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.VideoChatDao;
import com.web.youneeds.dto.VideoChatDto;

@Repository
public class VideoChatDaoImpl implements VideoChatDao {

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
