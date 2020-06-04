package com.hzb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hzb.common.HigherResponse;
import com.hzb.entity.CartVo;
import com.hzb.entity.Food;
import com.hzb.service.FoodService;
import com.hzb.utils.UUIDUtils;

@RestController
@RequestMapping("/manage/food")
public class FoodCon {
	
	@Autowired
	private FoodService foodService;
	
	@ResponseBody
	@RequestMapping("/list.do")
	public HigherResponse<Object> queryProByPage(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "4") Integer pageSize) {
		return foodService.getPageBeanFood(pageNum, pageSize);
	}
	
	@ResponseBody
	@RequestMapping("/search.do")
	public HigherResponse<List<Food>> searchQueryProByPage(Integer proId, String proName,
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "4") Integer pageSize) {
		Food product = new Food();
		product.setId(proId);
		product.setName(proName);
		return foodService.searchProByPage(product, pageNum, pageSize);
	}
	
	
	@ResponseBody
	@RequestMapping("/save.do")
	public HigherResponse<Object> uploadPhoto(Food food,MultipartFile file)throws IllegalStateException, IOException {
		//添加商品到数据库表
		return foodService.addOneFood(food, file);
		
		
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public HigherResponse<Object> upadtePhoto(Food food,MultipartFile file)throws IllegalStateException, IOException {
		//修改商品到数据库表
		return foodService.updateOneFood(food, file);
		
		
	}
	
	
	
	// 通过菜品ID 删除菜品
			@ResponseBody
			@RequestMapping("/delete.do")
			public HigherResponse<Object> removeOneFood(Integer pId) {
				return foodService.removeOneFood(pId);
			}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/user/list.do")
	public HigherResponse<Object> queryProByCIdAndName(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = "6") Integer pageSize,Integer cId,String pName) {
		Food food = new Food();
		food.setCategory_id(cId);
		food.setName(pName);
		HigherResponse<Object> queryProByCIdAndName = foodService.queryProByCIdAndName(pageNum, pageSize, food);
		
		return queryProByCIdAndName;
	}
	
	
	@ResponseBody
	@RequestMapping("/detail.do")
	public HigherResponse<Food> queryProInfoByPid(Integer pId){
		return foodService.queryProInfoByPid(pId);
	}

	
	

}
