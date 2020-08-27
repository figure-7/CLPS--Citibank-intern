package com.clps.mybatis.mapper;

import com.clps.mybatis.bean.Customer;

public interface CustomerMapper {
	
	public int saveCustomer(Customer customer) throws Exception;
	
}
