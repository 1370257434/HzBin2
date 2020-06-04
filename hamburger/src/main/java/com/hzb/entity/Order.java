package com.hzb.entity;

import java.math.BigDecimal;
import java.util.List;

import com.hzb.utils.UUIDUtils;

public class Order {
	
	private List<OrderItem> orderItemlist;
	private BigDecimal orderTotalPrice;
	
	// 服务器图像路径名称
	private String imageHost = UUIDUtils.IMGS_HOST;
	
	
	public Order() {
		super();
	}

	
	

	public List<OrderItem> getOrderItemlist() {
		return orderItemlist;
	}




	public void setOrderItemlist(List<OrderItem> orderItemlist) {
		this.orderItemlist = orderItemlist;
	}




	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}




	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}




	public String getImageHost() {
		return imageHost;
	}




	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}




	public Order(List<OrderItem> orderItemlist, BigDecimal orderTotalPrice, String imageHost) {
		super();
		this.orderItemlist = orderItemlist;
		this.orderTotalPrice = orderTotalPrice;
		this.imageHost = imageHost;
	}


	@Override
	public String toString() {
		return "Order [orderItemlist=" + orderItemlist + ", orderTotalPrice=" + orderTotalPrice + ", imageHost="
				+ imageHost + "]";
	}


	
}
