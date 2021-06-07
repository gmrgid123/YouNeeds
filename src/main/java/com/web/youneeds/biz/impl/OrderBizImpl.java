package com.web.youneeds.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.dao.interf.OrderDao;
import com.web.youneeds.dto.OrderDto;

@Transactional
@Service
public class OrderBizImpl implements OrderBiz{
	
	@Autowired
	private OrderDao orderDao;
	
	
	@Override
	public OrderDto selectDetail(int order_id) {
		
		return orderDao.selectDetail(order_id);
	}
	

	@Override
	public int paying(OrderDto orderDto) {
		
		return orderDao.paying(orderDto);
	}


	@Override
	public List<OrderDto> userMyPageInfo(Map<String, Integer> map) {
		
		return orderDao.userMyPageInfo(map);
	}

	@Override
	public int selectListMaxLength(int m_uid) {
		Integer temp = orderDao.selectListMaxLength(m_uid);

		if(temp == null) {
			return 0;
		} else {
			return temp.intValue();
		}
		
		
	}

	

}
