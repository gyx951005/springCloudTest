package com.cloud.provider.payment8001.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cloud.api.commons.entity.OrderEntity;


@Mapper
public interface OrderDao {

	/**
	 * 添加订单
	 * @param order
	 */
	int create(OrderEntity order);
	
	/**
	 * 根据id获取订单
	 * @param id
	 * @return
	 */
	OrderEntity getById(@Param("id") Long id);
	
	/**
	 * 查询全部的订单
	 * @return
	 */
	List<OrderEntity> getList();
}
