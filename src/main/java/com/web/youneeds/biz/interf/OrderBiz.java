package com.web.youneeds.biz.interf;

import java.util.List;

import com.web.youneeds.dto.OrderDto;

public interface OrderBiz {

	public List<OrderDto> selectList();
	public OrderDto selectOne(int order_id);
	public int insert(OrderDto order_id);
	public int update(OrderDto order_id);
	
}
