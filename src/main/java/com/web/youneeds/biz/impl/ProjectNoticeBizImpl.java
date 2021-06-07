package com.web.youneeds.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.biz.interf.ProjectNoticeBiz;
import com.web.youneeds.dao.interf.ProjectNoticeDao;
import com.web.youneeds.dto.ProjectNoticeDto;

@Transactional
@Service
public class ProjectNoticeBizImpl implements ProjectNoticeBiz {

	@Autowired
	private ProjectNoticeDao projectNoticeDao;
	
	
	@Override
	public List<ProjectNoticeDto> selectList(Map<String, Integer> map) {
		return projectNoticeDao.selectList(map);
	}

	@Override
	public ProjectNoticeDto selectOne(Map<String, Integer> map) {
		return projectNoticeDao.selectOne(map);
	}

	@Override
	public int insert(ProjectNoticeDto dto) {
		return projectNoticeDao.insert(dto);
	}

	@Override
	public int selectPjNoticeMaxLength(int p_id) {
		return projectNoticeDao.selectPjNoticeMaxLength(p_id);
	}


}
