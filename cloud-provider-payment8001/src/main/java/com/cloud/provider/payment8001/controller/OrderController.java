package com.cloud.provider.payment8001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.provider.payment8001.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create")
	public CommonResult<OrderEntity> create(@RequestBody OrderEntity order) {
		int create = orderService.create(order);
		if (create >0) {
			return new CommonResult<>(200, "success！");
		}
		return new CommonResult<>(500, "fail！");
	}
	
	@GetMapping("/getById/{id}")
	public CommonResult<OrderEntity> getById(@PathVariable Long id){
		OrderEntity orderEntity = orderService.getById(id);
		if (orderEntity != null) {
			return new CommonResult<OrderEntity>(200, "success", orderEntity);
		}
		return new CommonResult<>(500, "fail！");
	}
//	@GetMapping(value = "/", params = "id")
//	public CommonResult<OrderEntity> getById(@RequestParam Long id){
//		OrderEntity orderEntity = orderService.getById(id);
//		if (orderEntity != null) {
//			return new CommonResult<OrderEntity>(200, "success", orderEntity);
//		}
//		return new CommonResult<>(500, "fail！");
//	}
	@GetMapping("/")
	public List<OrderEntity> getList(){
		List<OrderEntity> list = orderService.getList();
		if (list != null) {
			return list;
		}
		return null;
	}
}
