package com.web.youneeds.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectDto> selectList(ProjectDto dto) {
		return sqlSession.selectList(NAMESPACE + "searchProjectList", dto);
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		return sqlSession.selectOne(NAMESPACE + "projectDetail", p_id);
		
	}

	@Override
	public int insert(ProjectDto dto) {
		return sqlSession.insert(NAMESPACE + "insertProject", dto);
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
	public int selectListMaxLength(int m_uid) {
		int max=0;
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectListMaxLength", m_uid);
		} catch (Exception e) {
			System.out.println("[error] : projectDao - selectListMaxLength");
			e.printStackTrace();
		}
		
		return max;
	}

}
