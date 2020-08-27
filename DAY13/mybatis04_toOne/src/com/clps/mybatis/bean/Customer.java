package com.clps.mybatis.bean;

public class Customer {

	private Integer custId;
	private String custName;
	private Integer custAge;

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

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custAge=" + custAge + "]";
	}

}
