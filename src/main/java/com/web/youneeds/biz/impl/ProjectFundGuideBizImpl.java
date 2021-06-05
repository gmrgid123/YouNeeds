package com.web.youneeds.biz.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.ProjectFundGuideBiz;
import com.web.youneeds.dao.interf.ProjectFundGuideDao;
import com.web.youneeds.dto.ProjectFundGuideDto;

@Service
public class ProjectFundGuideBizImpl implements ProjectFundGuideBiz{

	@Autowired
	private ProjectFundGuideDao projectFundGuide;
	

	@Override
	public ProjectFundGuideDto selectOne(int p_id) {
		return projectFundGuide.selectOne(p_id);
	}

	@Override
	public int insert(ProjectFundGuideDto dto) {
		return projectFundGuide.insert(dto);
	}

	@Override
	public int update(ProjectFundGuideDto dto) {
		return projectFundGuide.update(dto);
	}

	@Override
	public int delete(int p_id) {
		return projectFundGuide.delete(p_id);
	}

}
