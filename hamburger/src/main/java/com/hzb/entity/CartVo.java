package com.hzb.entity;

import java.math.BigDecimal;
import java.util.List;

import com.hzb.utils.UUIDUtils;

public class CartVo {
	
	private List<CartFoodVo> cartFoodVolist;
	private BigDecimal cartTotalPrice;
	private Boolean allChecked;
	// 服务器图像路径名称
	private String imageHost = UUIDUtils.IMGS_HOST;
	
	
	public CartVo() {
		super();
	}


	public List<CartFoodVo> getCartFoodVolist() {
		return cartFoodVolist;
	}


	public void setCartFoodVolist(List<CartFoodVo> cartFoodVolist) {
		this.cartFoodVolist = cartFoodVolist;
	}


	public BigDecimal getCartTotalPrice() {
		return cartTotalPrice;
	}


	public void setCartTotalPrice(BigDecimal cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}


	public Boolean getAllChecked() {
		return allChecked;
	}


	public void setAllChecked(Boolean allChecked) {
		this.allChecked = allChecked;
	}


	public String getImageHost() {
		return imageHost;
	}


	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}


	@Override
	public String toString() {
		return "CartVo [cartFoodVolist=" + cartFoodVolist + ", cartTotalPrice=" + cartTotalPrice + ", allChecked="
				+ allChecked + ", imageHost=" + imageHost + "]";
	}


	public CartVo(List<CartFoodVo> cartFoodVolist, BigDecimal cartTotalPrice, Boolean allChecked) {
		super();
		this.cartFoodVolist = cartFoodVolist;
		this.cartTotalPrice = cartTotalPrice;
		this.allChecked = allChecked;
		this.imageHost = UUIDUtils.IMGS_HOST;
		
	}
	
	

}
