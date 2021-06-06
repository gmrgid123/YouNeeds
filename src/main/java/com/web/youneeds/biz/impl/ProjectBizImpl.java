package com.web.youneeds.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.biz.interf.ProjectBiz;
import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;

@Transactional
@Service
public class ProjectBizImpl implements ProjectBiz{
	
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<ProjectDto> selectList(Map map) {
		return projectDao.selectList(map);
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		return projectDao.selectOne(p_id);
	}

	@Override
	public int insert(ProjectDto dto) {
		int res = 0;
		
		String startDate = dto.getStart_date();
		String endDate = dto.getEnd_date();
		String[] startDateArr = startDate.split("T");
		String[] endDateArr = endDate.split("T");
		dto.setStart_date(startDateArr[0] + " " + startDateArr[1]);
		dto.setEnd_date(endDateArr[0] + " " + endDateArr[1]);
		
		res = projectDao.insertProject(dto);
		dto.getProjectFundGuideDto().setP_id(dto.getP_id());
		dto.getProjectIntroDto().setP_id(dto.getP_id());
		dto.getProjectTilteImgDto().setP_id(dto.getP_id());
		
		res += projectDao.insertImgTitle(dto.getProjectTilteImgDto());
		res += projectDao.insertIntro(dto.getProjectIntroDto());
		res += projectDao.insertGuide(dto.getProjectFundGuideDto());
				
		
		return res;
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

	@Override
	public List<ProjectDto> creatorMyPageInfo(Map<String, Integer> map) {
		return projectDao.creatorMyPageInfo(map);
	}

	@Override
	public int selectListMaxLength(int m_uid) {
		Integer temp = projectDao.selectListMaxLength(m_uid);
		
		if(temp == null) {
			return 0;
		} else {
			return temp.intValue();
		}

	}

	@Override
	public ProjectDto selectDetailIntro(int p_id) {
		return projectDao.selectDetailIntro(p_id);
	}

	@Override
	public int sumOrder(int p_id) {
		Integer res = projectDao.sumOrder(p_id);
		
		if(res==null) {
			return 0;
		} else {
			return res.intValue();
		}
		
		
	}

	@Override
	public int orderCount(int p_id) {
		Integer res = projectDao.orderCount(p_id);
		
		if(res==null) {
			return 0;
		} else {
			return res.intValue();
		}
		
	}

	@Override
	public ProjectDto selectProjectInform(int p_id) {
		return projectDao.selectProjectInform(p_id);
	}

	@Override
	public int selectWriter(int p_id) {
		return projectDao.selectWriter(p_id);
	}

	@Override
	public ProjectDto selectProjectJoinGuide(int p_id) {
		return projectDao.selectProjectJoinGuide(p_id);
	}

	@Override
	public List<ProjectDto> selectRecentList() {
		return projectDao.selectRecentList();
	}

	@Override
	public int selectProjectMax(String p_category) {
		return projectDao.selectProjectMax(p_category);
	}

}
