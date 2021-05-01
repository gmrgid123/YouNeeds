package com.web.youneeds.biz.impl;

import java.util.List;

import com.web.youneeds.biz.interf.ProjectNoticeBiz;
import com.web.youneeds.dao.interf.ProjectNoticeDao;
import com.web.youneeds.dto.ProjectNoticeDto;

public class ProjectNoticeBizImpl implements ProjectNoticeBiz {

	private ProjectNoticeDao poejctNoticeDao;
	
	
	@Override
	public List<ProjectNoticeDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectNoticeDto selectOne(int p_notice_no, int p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProjectNoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProjectNoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int p_notice_no, int p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
