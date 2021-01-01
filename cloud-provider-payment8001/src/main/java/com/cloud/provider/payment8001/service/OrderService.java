package com.cloud.provider.payment8001.service;

import java.util.List;

import com.cloud.api.commons.entity.OrderEntity;


public interface OrderService {

	
	public int create(OrderEntity order);
	
	public OrderEntity getById(Long id);
	
	public List<OrderEntity> getList();
}
