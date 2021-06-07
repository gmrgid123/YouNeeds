package com.web.youneeds.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectNoticeDao;
import com.web.youneeds.dto.ProjectNoticeDto;

@Repository
public class ProjectNoticeDaoImpl implements ProjectNoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProjectNoticeDto> selectList(Map<String, Integer> map) {
		List<ProjectNoticeDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public ProjectNoticeDto selectOne(Map<String, Integer> map) {
		ProjectNoticeDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectOne", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(ProjectNoticeDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}



	@Override
	public int selectPjNoticeMaxLength(int p_id) {
		int max = 0;
		
		System.out.println(NAMESPACE+"selectMaxLength");
		
		try {
			max = sqlSession.selectOne(NAMESPACE+"selectMaxLength", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return max;
	}


}
