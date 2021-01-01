package com.cloud.eureka.consumer.payment8001.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cloud.eureka.consumer.payment8001.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService{

	@Override
	public String hystrixOk(int id) {
		return "线程池 ：" + Thread.currentThread().getName() + "paymentOk,id:" + id +"\t 哈哈哈" ;
	}

	@Override
	@HystrixCommand(fallbackMethod = "hystrixTimeOutHandler", commandProperties = 
		{@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
	public String hystrixTimeOut(int id) {
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池 ：" + Thread.currentThread().getName() + "paymentTimeOut,id:" + id +"\t 哈哈哈";
	}

	public String hystrixTimeOutHandler(int id) {
		return "线程池 ：" + Thread.currentThread().getName() + "系统繁忙，稍后再试！啊呜";
	}

	@Override
	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
	        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
	        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
	        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
	})
	public String paymentCircuitBreaker(int id) {
		if(id < 0) {
			throw new RuntimeException("id 不能为负！");
		}
		return "线程池 ：" + Thread.currentThread().getName() + "id:" + id;
	}
	
	public String paymentCircuitBreaker_fallback(int id) {
		return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
	}
}
