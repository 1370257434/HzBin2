package com.hzb.service;

import javax.servlet.http.HttpServletRequest;

import com.hzb.common.HigherResponse;
import com.hzb.entity.CartVo;

public interface CartService {
	
	//根据用户ID查询对应的购物车信息
		public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request);

		
		//添加购物车
		public HigherResponse<CartVo> addOneFoodToCart(Integer proId,Integer count,HttpServletRequest request);
		
		
		//从购物车里删除某件菜品
		public HigherResponse<CartVo> removeOneFoodFromCart(Integer cartId,HttpServletRequest request);
		
		//从购物车里修改菜品数量
		public HigherResponse<CartVo> updateCartFoodCount(Integer cartId,Integer count,HttpServletRequest request);
		
		//从购物车里修改菜品选中状态
		public HigherResponse<CartVo> updateCartFoodCheck(Integer cartId,Integer check,HttpServletRequest request);
		
		
}
