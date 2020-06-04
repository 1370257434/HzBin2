package com.hzb.dao;

import java.util.List;

import com.hzb.entity.Food;

public interface FoodDao {
	
	//食物列表分页查询
		public List<Food> pageQueryPro();
		
	//搜索列表分页查询
		public List<Food> searchProByPage(Food food);
		
		
	//添加菜品
		public Boolean addOneFood(Food food);
		
	//删除菜品
		public Boolean removeFood(Integer pId);
		
    //修改菜品
		public Boolean updateOneFood(Food food);
		
		
		
		
		
		
		
		//用户门户接口
		//根据类别ID 和  菜品名查询菜品
		public List<Food> queryProByCIdAndKeyWord(Food food);

		
		//根据商品id查询商品信息
		public Food queryProInfoByPid(Integer pId);
		
}
