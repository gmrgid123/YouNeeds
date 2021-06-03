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
	public List<ProjectDto> selectList(ProjectDto dto) {
		return projectDao.selectList(dto);
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		return projectDao.selectOne(p_id);
	}

	@Override
	public int insert(ProjectDto dto) {
		String startDate = dto.getStart_date();
		String endDate = dto.getEnd_date();
		String[] startDateArr = startDate.split("T");
		String[] endDateArr = endDate.split("T");
		dto.setStart_date(startDateArr[0] + " " + startDateArr[1]);
		dto.setEnd_date(endDateArr[0] + " " + endDateArr[1]);
		
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
