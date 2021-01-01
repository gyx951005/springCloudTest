package com.cloud.eureka.openfeign.order80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.openfeign.order80.feign.PaymentFeignService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private PaymentFeignService paymentFeignService;
	
	@GetMapping("/getById/{id}")
	public CommonResult<OrderEntity> getById(@PathVariable("id") Long id){
		return paymentFeignService.getById(id);
	}
	
	@PostMapping("/create")
	public CommonResult<OrderEntity> create(@RequestBody OrderEntity order){
		return paymentFeignService.create(order);
	}
}
