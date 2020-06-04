package com.hzb.dao;

import java.util.List;

import com.hzb.entity.Food;

public interface FoodDao {
	
	//ʳ���б��ҳ��ѯ
		public List<Food> pageQueryPro();
		
	//�����б��ҳ��ѯ
		public List<Food> searchProByPage(Food food);
		
		
	//��Ӳ�Ʒ
		public Boolean addOneFood(Food food);
		
	//ɾ����Ʒ
		public Boolean removeFood(Integer pId);
		
    //�޸Ĳ�Ʒ
		public Boolean updateOneFood(Food food);
		
		
		
		
		
		
		
		//�û��Ż��ӿ�
		//�������ID ��  ��Ʒ����ѯ��Ʒ
		public List<Food> queryProByCIdAndKeyWord(Food food);

		
		//������Ʒid��ѯ��Ʒ��Ϣ
		public Food queryProInfoByPid(Integer pId);
		
}
