package com.hzb.dao;

import java.util.List;

import com.hzb.entity.User;



public interface UserDao {
	
	// 查询所有用户
	List<User> queryAllUser();
	
	// 查询所有管理员
	List<User> queryAllAUser();
	


	/**
	 * 根据用户名和密码查询管理员信息
	 */
	User queryUserByUserNameAndPsw(User user);
	
	//添加一个用户
	Boolean addOneUser(User user);
	
	//添加一个管理员
		Boolean addOneAUser(User user);
		
	//检查用户名或邮箱是否唯一
	User cheackNameOrNumberExists(User user);
	
	/**
	 * 根据用户名和密码查询用户信息
	 */
	User queryNameAndPsw(User user);

}
