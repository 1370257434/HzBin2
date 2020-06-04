package com.hzb.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hzb.common.HigherResponse;
import com.hzb.entity.CartVo;
import com.hzb.entity.Food;

public interface FoodService {

	
	public HigherResponse<Object> getPageBeanFood(Integer pageNum,Integer pageSize);
	
	public HigherResponse<List<Food>> searchProByPage(Food food,Integer pageNum,Integer pageSize);
	
	public HigherResponse<Object> addOneFood(Food food,  MultipartFile file)throws IllegalStateException, IOException;
	
	
	public HigherResponse<Object> updateOneFood(Food food,  MultipartFile file) throws IllegalStateException, IOException;
	
	//删除菜品
	public HigherResponse<Object> removeOneFood(Integer pId);
	
	
	
	
	
	
	
	
	//用户门户
		public HigherResponse<Object> queryProByCIdAndName(Integer pageNum,Integer pageSize,Food food);
		
		public HigherResponse<Food> queryProInfoByPid(Integer pId);
		
		
}
