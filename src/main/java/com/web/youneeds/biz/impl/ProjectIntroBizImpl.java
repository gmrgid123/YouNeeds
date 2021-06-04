package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.ProjectIntroBiz;
import com.web.youneeds.dao.interf.ProjectIntroDao;
import com.web.youneeds.dto.ProjectIntroDto;

@Service
public class ProjectIntroBizImpl implements ProjectIntroBiz {

	@Autowired
	private ProjectIntroDao projectIntroDao;
	
	@Override
	public List<ProjectIntroDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectIntroDto selectOne(int p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProjectIntroDto dto) {
		return projectIntroDao.insert(dto);
	}

	@Override
	public int update(ProjectIntroDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
