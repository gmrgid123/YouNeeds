package com.web.youneeds.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.youneeds.dao.interf.CreatorDao;
import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;

@Repository
public class CreatorDaoImpl implements CreatorDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CreatorDto> creatorPageInfo(int m_uid) {
		List<CreatorDto> dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"creatorPageInfo", m_uid);
		} catch (Exception e) {
			System.out.println("[error] : creatorDao - creatorpageInfo");
			e.printStackTrace();
		}
		
		return dto;
	}

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
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"create_update", dto);

			System.out.println("update");
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int mupdate(MemberDto mdto) {
		int res = 0;
				
				try {
					res = sqlSession.update(NAMESPACE+"c_update", mdto);
					System.out.println("update");
				} catch (Exception e) {
					System.out.println("[error] : update");
					e.printStackTrace();
				}
				
				return res;
	}

}
