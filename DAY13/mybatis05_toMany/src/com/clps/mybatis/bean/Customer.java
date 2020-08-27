package com.clps.mybatis.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Integer custId;
	private String custName;
	private Integer custAge;
	
	private Set<Order> orderSet = new HashSet<Order>(); //对多关联属性

	public Customer() {
		super();
	}

	public Customer(Integer custId, String custName, Integer custAge) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAge = custAge;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getCustAge() {
		return custAge;
	}

	public void setCustAge(Integer custAge) {
		this.custAge = custAge;
	}
	
	

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custAge=" + custAge + "]";
	}


}
