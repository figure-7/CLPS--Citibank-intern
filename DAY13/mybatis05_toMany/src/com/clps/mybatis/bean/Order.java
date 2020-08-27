package com.clps.mybatis.bean;

public /*final*/ class Order {

	private Integer orderId;
	private String orderName;
	private Double orderAmount;

	public Order() {
		super();
	}

	public Order(Integer orderId, String orderName, Double orderAmount) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderAmount = orderAmount;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName
				+ ", orderAmount=" + orderAmount + "]";
	}

}
