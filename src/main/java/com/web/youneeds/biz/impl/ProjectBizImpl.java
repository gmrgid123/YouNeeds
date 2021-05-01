package com.web.youneeds.biz.impl;

import java.util.List;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;

public class ProjectBizImpl implements ProjectBiz{

	private ProjectDao projectDao;
	
	@Override
	public List<ProjectDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProjectDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProjectDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
