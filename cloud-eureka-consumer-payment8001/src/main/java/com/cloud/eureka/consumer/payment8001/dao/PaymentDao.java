package com.cloud.eureka.consumer.payment8001.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.api.commons.entity.OrderEntity;

@Mapper
public interface PaymentDao {

	
	public int create(OrderEntity order);
	
	public OrderEntity getById(@Param("id")Long id);
}
