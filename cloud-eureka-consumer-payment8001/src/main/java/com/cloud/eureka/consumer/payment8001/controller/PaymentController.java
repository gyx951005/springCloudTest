package com.cloud.eureka.consumer.payment8001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.consumer.payment8001.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/getById/{id}")
	public CommonResult<OrderEntity> getById(@PathVariable("id") Long id){
		OrderEntity orderEntity = paymentService.getById(id);
		if (orderEntity != null) {
			return new CommonResult<OrderEntity>(200, port +"success", orderEntity);
		}
		return new CommonResult<OrderEntity>(444, port + "fail", null);
	}
	
	@PostMapping("/create")
	public CommonResult<OrderEntity> create(@RequestBody OrderEntity order){
		int count = paymentService.create(order);
		if(count > 0) {
			return new CommonResult<>(200, port + "success");
		}
		return new CommonResult<>(444, port + "fail");
	}
}
