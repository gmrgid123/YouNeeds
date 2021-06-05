package com.web.youneeds.dao.impl;

import java.util.List;

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
	public List<ProjectNoticeDto> selectList() {
		return null;
	}

	@Override
	public ProjectNoticeDto selectOne(int p_notice_no, int p_id) {
		return null;
	}

	@Override
	public int insert(ProjectNoticeDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(ProjectNoticeDto dto) {
		return 0;
	}

	@Override
	public int delete(int p_notice_no, int p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
