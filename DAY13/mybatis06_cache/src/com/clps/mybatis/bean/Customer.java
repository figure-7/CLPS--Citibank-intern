package com.clps.mybatis.bean;

import java.io.Serializable;

public class Customer implements Serializable{
	private Integer custId;
	private String custName;
	private int custAge;

	public Customer() {
		super();
	}

	public Customer(Integer custId, String custName, int custAge) {
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

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custAge=" + custAge + "]";
	}

}
