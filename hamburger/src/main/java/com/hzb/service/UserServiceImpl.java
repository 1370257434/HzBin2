package com.hzb.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzb.common.HigherResponse;
import com.hzb.dao.UserDao;
import com.hzb.entity.User;



@Service
public class UserServiceImpl  implements UserService {
	
	@Autowired
	private UserDao userDao; 
	
	
	// Override
		public List<User> queryAllUser() {

			return userDao.queryAllUser();
		}

	
		@Override
		public HigherResponse<User> queryUser(User user) {


			if (null == user) {
				return HigherResponse.getResponseFailed("用户名或密码不能为空！！");

			}
			if (null == user.getUserName()|| "".equals(user.getUserName())) {
				return HigherResponse.getResponseFailed("用户名不能为空!!");

			}
			if (null == user.getPassWord()|| "".equals(user.getPassWord())) {
				return HigherResponse.getResponseFailed("密码不能为空!!");

			}
			User queryUserByUserNameAndPsw = userDao.queryUserByUserNameAndPsw(user);
			if(null == queryUserByUserNameAndPsw) {
				return HigherResponse.getResponseFailed("用户名或密码错误！！！");
			}
			return HigherResponse.getResponseSuccess(queryUserByUserNameAndPsw);
		
		}


		@Override
		public HigherResponse<Object> pageQueryUser(Integer pageNum, Integer pageSize) {
			// 开启分页
			PageHelper.startPage(pageNum, pageSize);
			// 调用查询所有用户的方法
			List<User> queryAllUser = userDao.queryAllUser();
			PageInfo<User> pageInfo = new PageInfo<>(queryAllUser);
			if (null == pageInfo) {
				return HigherResponse.getResponseFailed("查询数据失败！");
			} else {
				return HigherResponse.getResponseSuccess(pageInfo);
			}
		}

		
		@Override
		public HigherResponse<Object> pageQueryAUser(Integer pageNum, Integer pageSize) {
			// 开启分页
							PageHelper.startPage(pageNum, pageSize);
							// 调用查询所有管理员的方法
							List<User> queryAllAUser = userDao.queryAllAUser();
							PageInfo<User> pageInfo = new PageInfo<>(queryAllAUser);
							if (null == pageInfo) {
								return HigherResponse.getResponseFailed("查询数据失败！");
							} else {
								return HigherResponse.getResponseSuccess(pageInfo);
							}
		}

		

		@Override
		public HigherResponse<User> cheakNameOrNumberExists(String val, String type) {
			if (null == val || "".equals(val)) {
				return HigherResponse.getResponseFailed("输入用户名或手机号码不能为空，请重试！！！");
			} 
			if (null == type || "".equals(type)) {
				return HigherResponse.getResponseFailed("服务器异常！！！");
			}
			
			User user = new User();
			if("username".equals(type)) {
				user.setUserName(val);			
			}else if("number".equals(type)) {
				user.setNumber(val);
			}
			System.out.println(user.getUserName());
			User cheackNameOrNumberExists = userDao.cheackNameOrNumberExists(user);
			if(null != cheackNameOrNumberExists) {
				return HigherResponse.getResponseFailed(type+"已注册,请重新填写！！！");
			}
			return HigherResponse.getResponseSuccess(type+"可用！！！");
		}


		@Override
		public HigherResponse<Boolean> register(User user) {
			//判断用户是否为空
			if(null == user) {
				HigherResponse.getResponseFailed("服务器异常！！！");
			}
			if(null == user.getUserName() || "".equals(user.getUserName())) {
				HigherResponse.getResponseFailed("用户名不能为空！！！");
			}
			if(null == user.getNumber() || "".equals(user.getNumber())) {
				HigherResponse.getResponseFailed("手机号码不能为空！！！");
			}
			if(null == user.getPassWord() || "".equals(user.getPassWord())) {
				HigherResponse.getResponseFailed("密码不能为空！！！");
			}
			//判断用户名是否已注册
			
			//判断邮箱是否已经注册
			
			
			Boolean addOneUser = userDao.addOneUser(user);
			
			if(false == addOneUser) {
				return HigherResponse.getResponseFailed("注册失败，请重新注册！！！");
			}
			return HigherResponse.getResponseSuccess("注册成功！！！");
		}

		
		
		

		@Override
		public HigherResponse userLogin(String username, String psw, HttpSession session) {
			if (username == null || username.length() == 0) {
				return HigherResponse.getResponseFailed("用户名不能为空！！");

			}
			if (psw == null || psw.length() == 0) {
				return HigherResponse.getResponseFailed("密码不能为空!!");

			}
			User user = new User();
			user.setUserName(username);
			user.setPassWord(psw);
			User queryNameAndPsw = userDao.queryNameAndPsw(user);

			if (null == queryNameAndPsw) {
				return HigherResponse.getResponseFailed("用户名不存在，请重新输入");
			}

			session.setAttribute("user",queryNameAndPsw);

			return HigherResponse.getResponseSuccess(queryNameAndPsw);
		}


		@Override
		public HigherResponse<Boolean> registerA(User user) {
			//判断用户是否为空
			if(null == user) {
				HigherResponse.getResponseFailed("服务器异常！！！");
			}
			if(null == user.getUserName() || "".equals(user.getUserName())) {
				HigherResponse.getResponseFailed("用户名不能为空！！！");
			}
			if(null == user.getNumber() || "".equals(user.getNumber())) {
				HigherResponse.getResponseFailed("手机号码不能为空！！！");
			}
			if(null == user.getPassWord() || "".equals(user.getPassWord())) {
				HigherResponse.getResponseFailed("密码不能为空！！！");
			}
			
			//判断用户名是否已注册
			
			//判断邮箱是否已经注册
			
			
			Boolean addOneAUser = userDao.addOneAUser(user);
			
			if(false == addOneAUser) {
				return HigherResponse.getResponseFailed("注册失败，请重新注册！！！");
			}
			return HigherResponse.getResponseSuccess("注册成功！！！");
		}


		

		
}
