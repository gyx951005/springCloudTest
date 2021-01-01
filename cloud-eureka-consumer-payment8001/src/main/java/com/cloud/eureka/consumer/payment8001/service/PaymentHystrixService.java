package com.cloud.eureka.consumer.payment8001.service;

public interface PaymentHystrixService {

	
	public String hystrixOk(int id);
	
	public String hystrixTimeOut(int id);
	
	public String paymentCircuitBreaker(int id);
}
