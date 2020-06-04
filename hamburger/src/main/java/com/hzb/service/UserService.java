package com.hzb.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hzb.common.HigherResponse;
import com.hzb.entity.User;

public interface UserService {
	
	//查询所有用户的接口
		List<User> queryAllUser();
		
		
		
       //根据用户名密码查询用户信息
		public HigherResponse userLogin(String username,String psw,HttpSession session);
		HigherResponse<User> queryUser(User user);
		
		//分页查询用户列表
		public HigherResponse<Object> pageQueryUser(Integer pageNum,Integer pageSize);
		
		//分页查询管理员列表
		public HigherResponse<Object> pageQueryAUser(Integer pageNum,Integer pageSize);
				
		
		//注册用户
		public HigherResponse<Boolean> register (User user);
		
		//注册管理员
				public HigherResponse<Boolean> registerA (User user);
	
		
		//检查用户名是否有效
		public HigherResponse<User> cheakNameOrNumberExists(String val,String type);
}