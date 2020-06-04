package com.hzb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzb.common.HigherResponse;
import com.hzb.dao.FoodDao;
import com.hzb.entity.Food;
import com.hzb.utils.UUIDUtils;

@Service
public class FoodServiceImpl  implements FoodService{

	@Autowired
	private FoodDao foodDao;
	
	
	@Override
	public HigherResponse<Object> getPageBeanFood(Integer pageNum, Integer pageSize) {
		
			PageHelper.startPage(pageNum, pageSize);
			List<Food> pageQueryPro = foodDao.pageQueryPro();
			if (null == pageQueryPro) {
				return HigherResponse.getResponseFailed("û�в鵽�κ����ݣ�����");
			}
			PageInfo<Food> pageInfo = new PageInfo<>(pageQueryPro);
			return HigherResponse.getResponseSuccess(pageInfo);
	}


	@Override
	public HigherResponse<List<Food>> searchProByPage(Food food, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Food> searchProByPage = foodDao.searchProByPage(food);
		if (null == searchProByPage) {
			return HigherResponse.getResponseFailed("û�в鵽�κ����ݣ�����");
		}
		PageInfo<Food> pageInfo = new PageInfo<>(searchProByPage);
		return HigherResponse.getResponseSuccess(pageInfo);
		}


	@Override
	public HigherResponse<Object> addOneFood(Food food , MultipartFile file) throws IllegalStateException, IOException {
		if (null == food) { 
			return HigherResponse.getResponseFailed("�������쳣������");
		}
		if (null == file) {
			return HigherResponse.getResponseFailed("ͼƬΪ�գ�����");
		}
		
		//����ΨһͼƬ��
		String imgName = UUIDUtils.getUUID();
		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String suffixName = originalFilename.substring(lastIndexOf);
		if(!".jpg".equalsIgnoreCase(suffixName) &&  !".png".equals(suffixName)) {
		
		return HigherResponse.getResponseFailed("�ϴ�ͼƬ��ʽ���󣡣���");
			
		}
		
		
		imgName += suffixName;
				
		food.setMain_image(imgName);
		Boolean addOneFood = foodDao.addOneFood(food);
		if (false == addOneFood) {
			return HigherResponse.getResponseFailed("���ʧ�ܣ������³��ԣ�����");
		}
		//�ϴ�ͼƬ������ָ��Ŀ¼
		file.transferTo(new File("D:\\Himages\\"+imgName));
		return HigherResponse.getResponseSuccess(addOneFood);
	}

	
	@Override
	public HigherResponse<Object> updateOneFood(Food food, MultipartFile file) throws IllegalStateException, IOException {
		if (null == food) { 
			return HigherResponse.getResponseFailed("�������쳣������");
		}
		if (null == file) {
			return HigherResponse.getResponseFailed("ͼƬΪ�գ�����");
		}
		
		//����ΨһͼƬ��
		String imgName = UUIDUtils.getUUID();
		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String suffixName = originalFilename.substring(lastIndexOf);
		if(!".jpg".equalsIgnoreCase(suffixName) &&  !".png".equals(suffixName)) {
		
		return HigherResponse.getResponseFailed("�ϴ�ͼƬ��ʽ���󣡣���");
			
		}
		
		imgName += suffixName;
				
		food.setMain_image(imgName);
		Boolean updateOneFood = foodDao.updateOneFood(food);
		if (false == updateOneFood) {
			return HigherResponse.getResponseFailed("���ʧ�ܣ������³��ԣ�����");
		}
		//�ϴ�ͼƬ������ָ��Ŀ¼
		file.transferTo(new File("D:\\Himages\\"+imgName));
		return HigherResponse.getResponseSuccess(updateOneFood);
	}
	
	
	
	

	@Override
	public HigherResponse<Object> queryProByCIdAndName(Integer pageNum, Integer pageSize, Food food) {
		if (null == food) {
			return HigherResponse.getResponseFailed("�������쳣������");
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Food> queryProByCIdAndKeyWord = foodDao.queryProByCIdAndKeyWord(food);
		if (null == queryProByCIdAndKeyWord) {
			return HigherResponse.getResponseFailed("û�в鵽�κ����ݣ�����");
		}
		PageInfo<Food> pageInfo = new PageInfo<>(queryProByCIdAndKeyWord);
		return HigherResponse.getResponseSuccess(pageInfo);
	}


	@Override
	public HigherResponse<Food> queryProInfoByPid(Integer pId) {
		if (null == pId) {
			return HigherResponse.getResponseFailed("�������쳣������");
		}
		Food queryProInfoByPid = foodDao.queryProInfoByPid(pId);
		if (null == queryProInfoByPid) {
			return HigherResponse.getResponseFailed("�������쳣������");
		}
		
		return HigherResponse.getResponseSuccess(queryProInfoByPid);
	}


	@Override
	public HigherResponse<Object> removeOneFood(Integer pId) {
		if (null == pId) {
			return HigherResponse.getResponseFailed("��������С���ˣ���");
		}
		Boolean removeOneFood = foodDao.removeFood(pId);
		if(false == removeOneFood) {
			return HigherResponse.getResponseFailed("��������С���ˣ������ԣ�����");
		}
		return HigherResponse.getResponseSuccess(removeOneFood);
	}


	
}


