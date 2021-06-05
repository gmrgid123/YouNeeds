package com.web.youneeds.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectIntroDao;
import com.web.youneeds.dto.ProjectIntroDto;

@Repository
public class ProjectIntroDaoImpl implements ProjectIntroDao{

	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectIntroDto> selectList() {
		return null;
	}

	@Override
	public ProjectIntroDto selectOne(int p_id) {
		return null;
	}

	@Override
	public int insert(ProjectIntroDto dto) {
		return sqlSession.insert(NAMESPACE + "insertProjectIntro", dto);
		
	}

	@Override
	public int update(ProjectIntroDto dto) {
		return 0;
	}

	@Override
	public int delete(int p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
