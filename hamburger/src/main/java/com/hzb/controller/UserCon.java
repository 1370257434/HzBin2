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
	 * �����󶨻���    key:value
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
	
	//�û���ҳ
		@ResponseBody
		@RequestMapping("/list.do")
		public HigherResponse<Object> pageCon(@RequestParam(required = true,defaultValue = "1") Integer pageNum,@RequestParam(required = true,defaultValue = "3")Integer pageSize){
			return userService.pageQueryUser(pageNum, pageSize);
		}
		
		//����Ա��ҳ
				@ResponseBody
				@RequestMapping("/admin/list.do")
				public HigherResponse<Object> pageCon2(@RequestParam(required = true,defaultValue = "1") Integer pageNum,@RequestParam(required = true,defaultValue = "3")Integer pageSize){
					return userService.pageQueryAUser(pageNum, pageSize);
				}
		
				//��ӹ���Ա
				@ResponseBody
				@RequestMapping("/registerA.do")
				public HigherResponse<Boolean> registerA(User user){
					return userService.registerA(user);
				}		
				
				
		
		//��֤�û����������Ƿ����
		@ResponseBody
		@RequestMapping("/check.do")
		public HigherResponse<User> cheackNameOrNumberExists(String val, String type){
			return userService.cheakNameOrNumberExists(val, type);
		}
	
		//�Ż�ע���û�
		@ResponseBody
		@RequestMapping("/register.do")
		public HigherResponse<Boolean> register(User user){
			return userService.register(user);
		}
	
		//�Ż��û���¼
		@ResponseBody
		@RequestMapping("/user/login.do")
		public HigherResponse<User> userLogin(String username, String psw,HttpServletRequest request) {
			HttpSession session = request.getSession();
			return userService.userLogin(username, psw, session);
		}
}