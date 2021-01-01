package com.cloud.eureka.consumer.payment8001.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.consumer.payment8001.dao.PaymentDao;
import com.cloud.eureka.consumer.payment8001.service.PaymentService;


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
	
	@Scheduled(cron = "0/2 * * * * *")
	public void scheduled1() {
		System.out.println(Thread.currentThread().getName() + "scheduled1  start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "scheduled1  end");
	}
	
	@Scheduled(cron = "0/2 * * * * *")
	public void scheduled2() {
		System.out.println(Thread.currentThread().getName() + "scheduled2  start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "scheduled2   end");
	}
	

}
