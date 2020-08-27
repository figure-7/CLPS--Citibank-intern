package com.clps.mybatis.mapper;

import com.clps.mybatis.bean.Order;

public interface OrderMapper {

	public abstract Order getOrderByOrderId(Integer orderId);
	
}
