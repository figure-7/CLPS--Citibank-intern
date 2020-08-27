package com.clps.mybatis.mapper;

import java.util.Set;

import com.clps.mybatis.bean.Order;


public interface OrderMapper {

	//帮助对端完成用户对定义集合的关联查询.
	public Set<Order> getOrderByCustId(Integer custId);
	
}
