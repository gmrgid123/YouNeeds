package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.CreatorDto;
import com.web.youneeds.dto.MemberDto;

public interface CreatorDao {
	String NAMESPACE = "member.";
	
	public List<CreatorDto> creatorPageInfo(int m_uid);
	public CreatorDto selectOne(int m_uid);
	public int insert(CreatorDto dto);
	public int update(CreatorDto dto);
	public int mupdate(MemberDto mdto);
}
