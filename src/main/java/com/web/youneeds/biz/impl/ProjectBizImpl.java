package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;

@Service
public class ProjectBizImpl implements ProjectBiz{
	
	@Autowired
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
		return projectDao.insert(dto);
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
