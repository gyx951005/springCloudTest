package com.cloud.eureka.consumer.payment8001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.eureka.consumer.payment8001.service.PaymentHystrixService;

@RestController
@RequestMapping("/payment")
public class PaymentHystrixController {

	@Autowired
	private PaymentHystrixService paymentHystrixService;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/hystrixOk/{id}")
	public String paymentHystrixOk(@PathVariable("id") int id) {
		return paymentHystrixService.hystrixOk(id) + port;
	}
	
	@GetMapping("/hystrixTimeOut/{id}")
	public String paymentHystrixTimeOut(@PathVariable("id") int id) {
		return paymentHystrixService.hystrixTimeOut(id) + port;
	}
}
