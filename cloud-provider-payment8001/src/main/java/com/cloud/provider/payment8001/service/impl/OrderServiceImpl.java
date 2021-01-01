package com.cloud.provider.payment8001.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.provider.payment8001.dao.OrderDao;
import com.cloud.provider.payment8001.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public int create(OrderEntity order) {
		return orderDao.create(order);
	}

	@Override
	public OrderEntity getById(Long id) {
		return orderDao.getById(id);
	}

	@Override
	public List<OrderEntity> getList() {
		return orderDao.getList();
	}

}
