package com.hzb.dao;

import java.util.List;


import com.hzb.entity.OrderItem;

public interface OrderDao {
	
	public Boolean addOneOrder(OrderItem orderItem);
	
	public List<OrderItem> getOrderByUserId(Integer userId); 
}
