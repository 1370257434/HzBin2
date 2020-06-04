package com.hzb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzb.common.HigherResponse;
import com.hzb.entity.CartVo;
import com.hzb.service.CartService;

@RestController
@RequestMapping("/portal/cart")
public class CartCon {
	
	@Autowired
	public CartService cartService;

	// 通过用户ID 查询购物车清单
	@ResponseBody
	@RequestMapping("/list.do")
	public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request) {
		return cartService.queryCartByUserId(request);
	}

	
	@ResponseBody
	@RequestMapping("/add.do")
	public HigherResponse<CartVo> addOneFoodToCart(Integer proId, Integer count, HttpServletRequest request) {
		return cartService.addOneFoodToCart(proId, count, request);
	}
	
	
	// 通过用户ID 删除购物车菜品
		@ResponseBody
		@RequestMapping("/delete.do")
		public HigherResponse<CartVo> removeOneFood(Integer cartId, HttpServletRequest request) {
			return cartService.removeOneFoodFromCart(cartId, request);
		}
		
		
		// 通过用户ID 修改购物车菜品数量
		@ResponseBody
		@RequestMapping("/update.do")
		public HigherResponse<CartVo> updateCartFoodCount(Integer cartId, Integer count, HttpServletRequest request) {
			return cartService.updateCartFoodCount(cartId, count, request);
		}

		
		// 通过用户ID 修改购物车菜品选中状态
				@ResponseBody
				@RequestMapping("/check.do")
				public HigherResponse<CartVo> updateCartFoodCheck(Integer cartId, Integer check, HttpServletRequest request) {
					return cartService.updateCartFoodCheck(cartId, check, request);
				}
	
}
