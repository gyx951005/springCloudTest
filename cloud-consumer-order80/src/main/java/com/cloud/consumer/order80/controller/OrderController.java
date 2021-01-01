package com.cloud.consumer.order80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String URL = "http://localhost:8001";
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getById/{id}")
	public CommonResult<OrderEntity> getById(@PathVariable("id") Long id){
		return restTemplate.getForObject(URL + "/order/getById/" + id, CommonResult.class);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/create")
	public CommonResult<OrderEntity> create(@RequestBody OrderEntity orderEntity){
		return restTemplate.postForObject(URL + "/order/create", orderEntity, CommonResult.class);
	}
}
