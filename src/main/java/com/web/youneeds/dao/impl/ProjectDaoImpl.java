package com.web.youneeds.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;
import com.web.youneeds.dto.ProjectFundGuideDto;
import com.web.youneeds.dto.ProjectIntroDto;
import com.web.youneeds.dto.ProjectTitleImgDto;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {
	
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectDto> selectList(Map map) {
		List<ProjectDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE + "searchProjectList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		ProjectDto res = null;
				
		try {
			res =  sqlSession.selectOne(NAMESPACE + "projectDetail", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
		
	}

	@Override
	public int insertProject(ProjectDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertProject", dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int insertIntro(ProjectIntroDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertIntro", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertImgTitle(ProjectTitleImgDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertImgData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertGuide(ProjectFundGuideDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertGuide", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	

	@Override
	public List<ProjectDto> creatorMyPageInfo(Map<String, Integer> map) {
		List<ProjectDto> dto = null;
		
		try {
			dto = sqlSession.selectList(NAMESPACE+"creatorMyPageInfo", map);
		} catch (Exception e) {
			System.out.println("[error] : projectDao - creatorMypageInfo");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public Integer selectListMaxLength(int m_uid) {
		Integer max=null;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength", m_uid);
		} catch (Exception e) {
			System.out.println("[error] : projectDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		return max;
	}

	@Override
	public ProjectDto selectDetailIntro(int p_id) {
		ProjectDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"projectDetailIntro", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Integer sumOrder(int p_id) {
		Integer res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "orderSum", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	@Override
	public Integer orderCount(int p_id) {
		Integer res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "orderCount", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public ProjectDto selectProjectInform(int p_id) {
		ProjectDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectProjectInform", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int selectWriter(int p_id) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectWriter", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public ProjectDto selectProjectJoinGuide(int p_id) {
		ProjectDto res = null; 
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectProjectJoinGuide", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<ProjectDto> selectRecentList() {
		List<ProjectDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectRecentList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int selectProjectMax(String p_category) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectProjectMax", p_category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}


}
