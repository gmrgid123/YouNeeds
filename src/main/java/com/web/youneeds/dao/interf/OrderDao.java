package com.web.youneeds.dao.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.OrderDto;

public interface OrderDao {
	String NAMESPACE = "OrderPaySql.";
	
	public OrderDto selectDetail(int order_id);
	public int paying(OrderDto orderDto);
	public List<OrderDto> userMyPageInfo(Map<String, Integer> map);
	public Integer selectListMaxLength(int m_uid);
	
}
