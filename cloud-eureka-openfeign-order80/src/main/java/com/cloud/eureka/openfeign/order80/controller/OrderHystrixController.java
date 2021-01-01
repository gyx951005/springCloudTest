package com.cloud.eureka.openfeign.order80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.eureka.openfeign.order80.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

	@Autowired
	private PaymentFeignService paymentFeignService;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hystrixOk/{id}")
	public String hystrixOk(@PathVariable("id") int id) {
		return paymentFeignService.paymentHystrixOk(id) + port;
	}
	
	@GetMapping("/hystrixTimeOut/{id}")
	@HystrixCommand(fallbackMethod = "hystrixTimeOutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
	})
	public String hystrixTimeOut(@PathVariable("id") int id) {
		return paymentFeignService.paymentHystrixTimeOut(id) +port;
	}
	
	public String hystrixTimeOutHandler(@PathVariable("id") int id) {
		return "消费者80 啊呜！";
	}
	
	@GetMapping("/hystrixText/{id}")
	@HystrixCommand
	public String hystrixText(@PathVariable("id") int id) {
		int i = 10/0;
		return paymentFeignService.paymentHystrixTimeOut(id) +port + "\t" +id;
	}
	
	public String payment_Global_FallbackMethod() {
		return "消费者全局兜底";
	}
}
