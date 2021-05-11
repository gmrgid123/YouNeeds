package com.web.youneeds.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectDao;
import com.web.youneeds.dto.ProjectDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	
	String NAMESPACE = "temp9.";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectDto> selectList(ProjectDto dto) {
		return sqlSession.selectList(NAMESPACE + "searchProjectList", dto);
	}

	@Override
	public ProjectDto selectOne(int p_id) {
		// TODO Auto-generated method stub
		return null;
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

}
