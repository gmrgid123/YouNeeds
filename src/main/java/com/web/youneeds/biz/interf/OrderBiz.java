package com.web.youneeds.biz.interf;

import java.util.List;
import java.util.Map;

import com.web.youneeds.dto.OrderDto;

public interface OrderBiz {

	public OrderDto selectDetail(int order_id);
	public int paying(OrderDto orderDto);
	public List<OrderDto> userMyPageInfo(Map<String, Integer> map);
	public int selectListMaxLength(int m_uid);
}
