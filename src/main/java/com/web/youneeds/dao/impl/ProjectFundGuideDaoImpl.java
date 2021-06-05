package com.web.youneeds.dao.impl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectFundGuideDao;
import com.web.youneeds.dto.ProjectFundGuideDto;

@Repository
public class ProjectFundGuideDaoImpl implements ProjectFundGuideDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ProjectFundGuideDto selectOne(int p_id) {
		ProjectFundGuideDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(ProjectFundGuideDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(ProjectFundGuideDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int delete(int p_id) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
