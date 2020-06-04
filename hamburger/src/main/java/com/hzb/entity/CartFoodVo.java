package com.hzb.entity;

import java.math.BigDecimal;

public class CartFoodVo {
	
	private Integer id;
	private Integer userId;
	private Integer foodId;
	private Integer quantity;
	private String foodName;
	private String foodMainImage;
	private BigDecimal foodPrice;
	// ×Ü¼Û
	private BigDecimal foodTotalPrice;
	// ¿â´æ
	private Integer foodStock;
	private Integer foodChecked;
	//
	private String limitQuantity;
	
	public CartFoodVo() {
		super();
	}

	public CartFoodVo(Integer id, Integer userId, Integer foodId, Integer quantity, String foodName,
			String foodMainImage, BigDecimal foodPrice, BigDecimal foodTotalPrice, Integer foodStock,
			Integer foodChecked) {
		super();
		this.id = id;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.foodName = foodName;
		this.foodMainImage = foodMainImage;
		this.foodPrice = foodPrice;
		this.foodTotalPrice = foodTotalPrice;
		this.foodStock = foodStock;
		this.foodChecked = foodChecked;
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

	public Integer getFoodStock() {
		return foodStock;
	}

	public void setFoodStock(Integer foodStock) {
		this.foodStock = foodStock;
	}

	public Integer getFoodChecked() {
		return foodChecked;
	}

	public void setFoodChecked(Integer foodChecked) {
		this.foodChecked = foodChecked;
	}

	public String getLimitQuantity() {
		return limitQuantity;
	}

	public void setLimitQuantity(String limitQuantity) {
		this.limitQuantity = limitQuantity;
	}

	@Override
	public String toString() {
		return "CartFoodVo [id=" + id + ", userId=" + userId + ", foodId=" + foodId + ", quantity=" + quantity
				+ ", foodName=" + foodName + ", foodMainImage=" + foodMainImage + ", foodPrice=" + foodPrice
				+ ", foodTotalPrice=" + foodTotalPrice + ", foodStock=" + foodStock + ", foodChecked=" + foodChecked
				+ ", limitQuantity=" + limitQuantity + "]";
	}
	
	
	
}
