package com.cloud.eureka.provider.payment8002.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.provider.payment8002.dao.PaymentDao;
import com.cloud.eureka.provider.payment8002.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public int create(OrderEntity order) {
		return paymentDao.create(order);
	}

	@Override
	public OrderEntity getById(Long id) {
		return paymentDao.getById(id);
	}
}
