package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.NoticeBiz;
import com.web.youneeds.dao.interf.NoticeDao;
import com.web.youneeds.dto.NoticeDto;

@Service
public class NoticeBizImpl implements NoticeBiz {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeDto> selectList(int p) {
		return noticeDao.selectList(p);
	}

	@Override
	public NoticeDto selectOne(int notice_id) {
		return noticeDao.selectOne(notice_id);
	}

	@Override
	public int insert(NoticeDto dto) {
		return noticeDao.insert(dto);
	}

	@Override
	public int update(NoticeDto dto) {
		
		return noticeDao.update(dto);
	}

	@Override
	public int delete(int notice_id) {
		return noticeDao.delete(notice_id);
	}

	@Override
	public int selectListMaxLength() {
		Integer temp = noticeDao.selectListMaxLength();
		
		if(temp == null) {
			return 0;
		} else {
			return temp.intValue();
		}
		
		
	}

}
