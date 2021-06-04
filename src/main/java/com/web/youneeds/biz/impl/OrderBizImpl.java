package com.web.youneeds.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.youneeds.biz.interf.OrderBiz;
import com.web.youneeds.dao.interf.OrderDao;
import com.web.youneeds.dto.OrderDto;

@Service
public class OrderBizImpl implements OrderBiz{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<OrderDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto selectOne(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public OrderDto selectDetail(int order_id) {
		
		return orderDao.selectDetail(order_id);
	}
	

	@Override
	public int paying(OrderDto orderDto) {
		
		return orderDao.paying(orderDto);
	}

	@Override
	public int update(OrderDto orderDto) {
		// TODO Auto-generated method stub
		return 0;
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
