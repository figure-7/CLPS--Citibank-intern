package com.clps.mybatis.mapper;

import com.clps.mybatis.bean.Customer;

public interface CustomerMapper {

	//为Order端提供帮助
	public abstract Customer getCustomerById(Integer custId);
	
}
