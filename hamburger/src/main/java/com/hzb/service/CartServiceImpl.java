package com.hzb.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzb.common.HigherResponse;
import com.hzb.dao.CartDao;
import com.hzb.dao.FoodDao;
import com.hzb.entity.CartFoodVo;
import com.hzb.entity.CartVo;
import com.hzb.entity.User;

@Service
public class CartServiceImpl  implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private FoodDao foodDao;

	@Override
	public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (null == user) {
			return HigherResponse.getResponseFailed("服务器出小差了！！");
		}
		
		List<CartFoodVo> cartFoodByUserId = cartDao.getCartFoodByUserId(user.getId());
		if(null == cartFoodByUserId) {
			return HigherResponse.getResponseFailed("服务器中没有您的购物车信息！！！");
		}
	
		CartVo cartVo = new CartVo();
		cartVo.setCartFoodVolist(cartFoodByUserId);
		BigDecimal bigDecimal = new BigDecimal(0.00);
		Boolean FlagAllChecked = true;
		for (int i=0;i<cartFoodByUserId.size();i++) {
			CartFoodVo cartFoodVo = cartFoodByUserId.get(i);
			if(cartFoodVo.getFoodChecked() == 1) {
				
				bigDecimal = bigDecimal.add(cartFoodVo.getFoodTotalPrice());
				
			}else {
				FlagAllChecked = false;
			}
			
		}
		
		cartVo.setCartTotalPrice(bigDecimal);
		cartVo.setAllChecked(FlagAllChecked);
		
		return HigherResponse.getResponseSuccess(cartVo);

		
	}

	@Override
	public HigherResponse<CartVo> addOneFoodToCart(Integer proId, Integer count, HttpServletRequest request) {

		HttpSession session = request.getSession();
		User attribute = (User)session.getAttribute("user");
		if (null == attribute) {
			return HigherResponse.getResponseFailed("登录信息获取失败，请重新登录！！");
		}
		Integer userId = attribute.getId();
		//构建购物车
		CartFoodVo cartFoodVo = new CartFoodVo();
		cartFoodVo.setUserId(userId);
		cartFoodVo.setFoodId(proId);
		cartFoodVo.setQuantity(count);
		Boolean addOneCartFood = cartDao.addOneCartFood(cartFoodVo);
		if(false == addOneCartFood) {
			return HigherResponse.getResponseFailed("添加失败，请重试！！！");
		}
		return queryCartByUserId(request);
	}

	@Override
	public HigherResponse<CartVo> removeOneFoodFromCart(Integer cartId, HttpServletRequest request) {
		if (null == cartId) {
			return HigherResponse.getResponseFailed("服务器出小差了！！");
		}
		Boolean removeOneFood = cartDao.removeOneFood(cartId);
		if(false == removeOneFood) {
			return HigherResponse.getResponseFailed("服务器出小差了，请重试！！！");
		}
		return queryCartByUserId(request);
	}

	@Override
	public HigherResponse<CartVo> updateCartFoodCount(Integer cartId, Integer count, HttpServletRequest request) {
		if (null == cartId) {
			return HigherResponse.getResponseFailed("服务器出小差了！！");
		}
		if (null == count) {
			return HigherResponse.getResponseFailed("服务器出小差了！！");
		}
		Boolean updateCartFoodCount = cartDao.updateCartFoodCount(cartId,count);
		if(false == updateCartFoodCount) {
			return HigherResponse.getResponseFailed("服务器出小差了，请重试！！！");
		}
		return queryCartByUserId(request);
	}

	@Override
	public HigherResponse<CartVo> updateCartFoodCheck(Integer cartId, Integer check, HttpServletRequest request) {
		if (null == cartId) {
			return HigherResponse.getResponseFailed("服务器1出小差了！！");
		}
		if (null == check) {
			return HigherResponse.getResponseFailed("服务器2出小差了！！");
		}
		Boolean updateCartFoodCheck = cartDao.updateCartFoodCheck(cartId,check);
		if(false == updateCartFoodCheck) {
			return HigherResponse.getResponseFailed("服务器3出小差了，请重试！！！");
		}
		return queryCartByUserId(request);
	}

	

}
