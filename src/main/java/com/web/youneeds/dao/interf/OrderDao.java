package com.web.youneeds.dao.interf;

import java.util.List;

import com.web.youneeds.dto.OrderDto;

public interface OrderDao {
	String NAMESPACE = "";
	
	public List<OrderDto> selectList();
	public OrderDto selectOne(int order_id);
	public int insert(OrderDto order_id);
	public int update(OrderDto order_id);
}
