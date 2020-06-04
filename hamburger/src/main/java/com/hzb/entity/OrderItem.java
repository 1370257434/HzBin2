package com.hzb.entity;

import java.math.BigDecimal;

public class OrderItem {
	
	private Integer id;
	private Integer orderNo;
	private Integer userId;
	private Integer foodId;
	private Integer quantity;
	private String foodName;
	private String foodMainImage;
	private BigDecimal foodPrice;
	// ×Ü¼Û
	private BigDecimal foodTotalPrice;
	
	
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer id,Integer orderNo, Integer userId, Integer foodId, Integer quantity, String foodName,
			String foodMainImage, BigDecimal foodPrice, BigDecimal foodTotalPrice) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.foodName = foodName;
		this.foodMainImage = foodMainImage;
		this.foodPrice = foodPrice;
		this.foodTotalPrice = foodTotalPrice;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodMainImage() {
		return foodMainImage;
	}

	public void setFoodMainImage(String foodMainImage) {
		this.foodMainImage = foodMainImage;
	}

	public BigDecimal getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(BigDecimal foodPrice) {
		this.foodPrice = foodPrice;
	}

	public BigDecimal getFoodTotalPrice() {
		return this.getFoodPrice().multiply(new BigDecimal(this.getQuantity()));
	}

	public void setFoodTotalPrice(BigDecimal foodTotalPrice) {
		this.foodTotalPrice = foodTotalPrice;
	}

	

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderNo=" + orderNo + ", userId=" + userId + ", foodId=" + foodId
				+ ", quantity=" + quantity + ", foodName=" + foodName + ", foodMainImage=" + foodMainImage
				+ ", foodPrice=" + foodPrice + ", foodTotalPrice=" + foodTotalPrice + "]";
	}

	
	
	
	
}
