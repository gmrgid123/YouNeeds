package com.web.youneeds.biz.impl;

import java.util.List;

import com.web.youneeds.biz.interf.NoticeBiz;
import com.web.youneeds.dao.interf.NoticeDao;
import com.web.youneeds.dto.NoticeDto;

public class NoticeBizImpl implements NoticeBiz {

	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDto selectOne(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int notice_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
