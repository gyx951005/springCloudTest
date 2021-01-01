package com.cloud.eureka.openfeign.order80.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cloud.api.commons.entity.CommonResult;
import com.cloud.api.commons.entity.OrderEntity;
import com.cloud.eureka.openfeign.order80.feign.impl.PaymentFeignServiceImpl;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER", fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

	@GetMapping("/payment/getById/{id}")
	public CommonResult<OrderEntity> getById(@PathVariable("id") Long id);
	
	@PostMapping("/payment/create")
	public CommonResult<OrderEntity> create(@RequestBody OrderEntity order);
	
	
	@GetMapping("/payment/hystrixOk/{id}")
	public String paymentHystrixOk(@PathVariable("id") int id);
	
	@GetMapping("/payment/hystrixTimeOut/{id}")
	public String paymentHystrixTimeOut(@PathVariable("id") int id);
}
