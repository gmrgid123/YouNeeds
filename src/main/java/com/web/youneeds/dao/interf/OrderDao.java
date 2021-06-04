package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.OrderDto;

public interface OrderDao {
	String NAMESPACE = "OrderPaySql.";
	
	public List<OrderDto> selectList();
	public OrderDto selectOne(int order_id);
	public OrderDto selectDetail(int order_id);
	public int paying(OrderDto orderDto);
	public int update(OrderDto orderDto);
	public List<OrderDto> myPageInfo(Map<String, Integer> map);
	public int selectListMaxLength(int m_uid);
	
}
