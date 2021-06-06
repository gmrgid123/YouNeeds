package com.web.youneeds.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.ProjectTitleImgBiz;
import com.web.youneeds.dao.interf.ProjectTitleImgDao;
import com.web.youneeds.dto.ProjectTitleImgDto;


@Service
public class ProjectTitleImgBizImpl implements ProjectTitleImgBiz{

	@Autowired
	private ProjectTitleImgDao projectTitleImgDao;
	

	@Override
	public ProjectTitleImgDto selectOne(int p_id) {
		return projectTitleImgDao.selectOne(p_id);
	}

	@Override
	public int insert(ProjectTitleImgDto dto) {
		return projectTitleImgDao.insert(dto);
	}

	@Override
	public int update(ProjectTitleImgDto dto) {
		return projectTitleImgDao.update(dto);
	}

	@Override
	public int delete(int p_id) {
		return projectTitleImgDao.delete(p_id);
	}

}
