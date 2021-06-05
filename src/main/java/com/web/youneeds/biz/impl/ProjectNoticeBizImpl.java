package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.ProjectNoticeBiz;
import com.web.youneeds.dao.interf.ProjectNoticeDao;
import com.web.youneeds.dto.ProjectNoticeDto;

@Service
public class ProjectNoticeBizImpl implements ProjectNoticeBiz {

	@Autowired
	private ProjectNoticeDao projectNoticeDao;
	
	
	@Override
	public List<ProjectNoticeDto> selectList() {
		return null;
	}

	@Override
	public ProjectNoticeDto selectOne(int p_notice_no, int p_id) {
		return null;
	}

	@Override
	public int insert(ProjectNoticeDto dto) {
		return projectNoticeDao.insert(dto);
	}

	@Override
	public int update(ProjectNoticeDto dto) {
		return 0;
	}

	@Override
	public int delete(int p_notice_no, int p_id) {
		return 0;
	}

}
