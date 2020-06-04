package com.hzb.dao;

import java.util.List;

import com.hzb.entity.User;



public interface UserDao {
	
	// ��ѯ�����û�
	List<User> queryAllUser();
	
	// ��ѯ���й���Ա
	List<User> queryAllAUser();
	


	/**
	 * �����û����������ѯ����Ա��Ϣ
	 */
	User queryUserByUserNameAndPsw(User user);
	
	//���һ���û�
	Boolean addOneUser(User user);
	
	//���һ������Ա
		Boolean addOneAUser(User user);
		
	//����û����������Ƿ�Ψһ
	User cheackNameOrNumberExists(User user);
	
	/**
	 * �����û����������ѯ�û���Ϣ
	 */
	User queryNameAndPsw(User user);

}
