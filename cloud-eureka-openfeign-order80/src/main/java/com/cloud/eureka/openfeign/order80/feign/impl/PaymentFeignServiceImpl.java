package com.cloud.eureka.openfeign.order80.feign.impl;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.openfeign.order80.feign.PaymentFeignService;

public class PaymentFeignServiceImpl implements PaymentFeignService{

	@Override
	public CommonResult<OrderEntity> getById(Long id) {
		return null;
	}

	@Override
	public CommonResult<OrderEntity> create(OrderEntity order) {
		return null;
	}

	@Override
	public String paymentHystrixOk(int id) {
		return "feign 啊呜";
	}

	@Override
	public String paymentHystrixTimeOut(int id) {
		return "feign 啊呜";
	}

}
