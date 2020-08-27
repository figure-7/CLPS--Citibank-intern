package com.clps.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;

import com.clps.mybatis.bean.Customer;

public interface CustomerAnnoMapper {

	@Insert("insert into tbl_cust(cust_name,cust_age) values(#{custName},#{custAge})")
	public int saveCustomer(Customer cust);
	
}
