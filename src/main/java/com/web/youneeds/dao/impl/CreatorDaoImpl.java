package com.web.youneeds.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.CreatorDao;
import com.web.youneeds.dto.CreatorDto;

@Repository
public class CreatorDaoImpl implements CreatorDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public CreatorDto selectOne(int m_uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CreatorDto dto) {
	int res = 0;
			
			try {
				res=sqlSession.insert(NAMESPACE+"c_insert", dto);
			} catch (Exception e) {
				System.out.println("error:c_insert");
				e.printStackTrace();
			}
			return res;
		
	}

	@Override
	public int update(CreatorDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
