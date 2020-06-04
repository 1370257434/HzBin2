package com.hzb.service;

import javax.servlet.http.HttpServletRequest;

import com.hzb.common.HigherResponse;
import com.hzb.entity.CartVo;

public interface CartService {
	
	//�����û�ID��ѯ��Ӧ�Ĺ��ﳵ��Ϣ
		public HigherResponse<CartVo> queryCartByUserId(HttpServletRequest request);

		
		//��ӹ��ﳵ
		public HigherResponse<CartVo> addOneFoodToCart(Integer proId,Integer count,HttpServletRequest request);
		
		
		//�ӹ��ﳵ��ɾ��ĳ����Ʒ
		public HigherResponse<CartVo> removeOneFoodFromCart(Integer cartId,HttpServletRequest request);
		
		//�ӹ��ﳵ���޸Ĳ�Ʒ����
		public HigherResponse<CartVo> updateCartFoodCount(Integer cartId,Integer count,HttpServletRequest request);
		
		//�ӹ��ﳵ���޸Ĳ�Ʒѡ��״̬
		public HigherResponse<CartVo> updateCartFoodCheck(Integer cartId,Integer check,HttpServletRequest request);
		
		
}
