package com.hzb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzb.entity.User;
import com.hzb.service.UserService;

@RestController
public class TestCon {
	
	@Autowired
	private UserService userSrvice;
	
	@RequestMapping("/test")
	public List<User> test() {
		
	List<User> queryAllUsers = userSrvice.queryAllUser();
		System.out.println(queryAllUsers);
		return queryAllUsers;
	}

}