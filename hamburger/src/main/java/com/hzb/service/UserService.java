package com.hzb.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hzb.common.HigherResponse;
import com.hzb.entity.User;

public interface UserService {
	
	//��ѯ�����û��Ľӿ�
		List<User> queryAllUser();
		
		
		
       //�����û��������ѯ�û���Ϣ
		public HigherResponse userLogin(String username,String psw,HttpSession session);
		HigherResponse<User> queryUser(User user);
		
		//��ҳ��ѯ�û��б�
		public HigherResponse<Object> pageQueryUser(Integer pageNum,Integer pageSize);
		
		//��ҳ��ѯ����Ա�б�
		public HigherResponse<Object> pageQueryAUser(Integer pageNum,Integer pageSize);
				
		
		//ע���û�
		public HigherResponse<Boolean> register (User user);
		
		//ע�����Ա
				public HigherResponse<Boolean> registerA (User user);
	
		
		//����û����Ƿ���Ч
		public HigherResponse<User> cheakNameOrNumberExists(String val,String type);
}