package com.petshop.servlets.shared;

import java.util.List;

import com.petshop.hibernate.entities.OrderDetail;

public class OrderView {
	private int id;
	private String status;
	private List<OrderDetail> orderDetails;
	private int totalPrice;
	public OrderView(int id, String status, List<OrderDetail> orderDetails, int totalPrice) {
		super();
		this.id = id;
		this.status = status;
		this.orderDetails = orderDetails;
		this.totalPrice = totalPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public OrderView()
	{
		
	}

}
