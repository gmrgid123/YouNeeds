package com.web.youneeds.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.ProjectTitleImgDao;
import com.web.youneeds.dto.ProjectTitleImgDto;

@Repository
public class ProjectTitleImgDaoImpl implements ProjectTitleImgDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public ProjectTitleImgDto selectOne(int p_id) {
		ProjectTitleImgDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectImgOne", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(ProjectTitleImgDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insertImgData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}

	@Override
	public int update(ProjectTitleImgDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "updateImg", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}

	@Override
	public int delete(int p_id) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "deleteImg", p_id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}

}
