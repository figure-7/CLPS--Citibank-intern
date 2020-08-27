package com.clps.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clps.mybatis.bean.Customer;


public interface CustomerMapper {
	List<Customer> getListByMinMaxAge(
				@Param("minAge") Integer minAge, 
				@Param("maxAge") Integer maxAge);

	List<Customer> getListBySeveralIds(@Param("custIdList") List<Integer> custIdList);
	
	
	void batchSaveCustomer(@Param("customerList") List<Customer> customerList);
	
	void saveCustomerClever(Customer customer);
	
	void updateCustomer(Customer customer);
}
