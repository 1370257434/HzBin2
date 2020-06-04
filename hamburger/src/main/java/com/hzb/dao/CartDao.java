package com.hzb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzb.entity.CartFoodVo;

public interface CartDao {
	
	public Boolean addOneCartFood(CartFoodVo cartFoodVo);
	
	public List<CartFoodVo> getCartFoodByUserId(Integer userId); 
	
	public Boolean removeOneFood(Integer cartId);
	
	public Boolean updateCartFoodCount(@Param("cartId")Integer cartId,@Param("count")Integer count);

	
	public Boolean updateCartFoodCheck(@Param("cartId")Integer cartId,@Param("check")Integer check);
}
