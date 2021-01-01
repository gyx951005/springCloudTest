package com.cloud.eureka.consumer.payment8001.service;

import com.cloud.api.commons.entity.OrderEntity;

public interface PaymentService {

	
	public int create(OrderEntity order);
	
	public OrderEntity getById(Long id);
}
