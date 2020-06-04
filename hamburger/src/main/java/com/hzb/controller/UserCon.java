package com.hzb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzb.common.HigherResponse;
import com.hzb.entity.User;
import com.hzb.service.UserService;


@RestController
@RequestMapping("/manage/user")
public class UserCon {

	@Autowired
	private UserService userService;

	
	/**
	 * 参数绑定机制    key:value
	 * @param userName
	 * @param psw
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login.do")
	public HigherResponse<User> login(@RequestParam("userName") String username,@RequestParam("psw") String password,HttpServletRequest request) {
		User user = new User(); 
		user.setUserName(username);
		user.setPassWord(password);
		HigherResponse<User> queryUser = userService.queryUser(user);
		
		return queryUser;
	}
	
	//用户分页
		@ResponseBody
		@RequestMapping("/list.do")
		public HigherResponse<Object> pageCon(@RequestParam(required = true,defaultValue = "1") Integer pageNum,@RequestParam(required = true,defaultValue = "3")Integer pageSize){
			return userService.pageQueryUser(pageNum, pageSize);
		}
		
		//管理员分页
				@ResponseBody
				@RequestMapping("/admin/list.do")
				public HigherResponse<Object> pageCon2(@RequestParam(required = true,defaultValue = "1") Integer pageNum,@RequestParam(required = true,defaultValue = "3")Integer pageSize){
					return userService.pageQueryAUser(pageNum, pageSize);
				}
		
				//添加管理员
				@ResponseBody
				@RequestMapping("/registerA.do")
				public HigherResponse<Boolean> registerA(User user){
					return userService.registerA(user);
				}		
				
				
		
		//验证用户名或邮箱是否存在
		@ResponseBody
		@RequestMapping("/check.do")
		public HigherResponse<User> cheackNameOrNumberExists(String val, String type){
			return userService.cheakNameOrNumberExists(val, type);
		}
	
		//门户注册用户
		@ResponseBody
		@RequestMapping("/register.do")
		public HigherResponse<Boolean> register(User user){
			return userService.register(user);
		}
	
		//门户用户登录
		@ResponseBody
		@RequestMapping("/user/login.do")
		public HigherResponse<User> userLogin(String username, String psw,HttpServletRequest request) {
			HttpSession session = request.getSession();
			return userService.userLogin(username, psw, session);
		}
}