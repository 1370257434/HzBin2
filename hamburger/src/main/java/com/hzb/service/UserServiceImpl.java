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
				return HigherResponse.getResponseFailed("�û��������벻��Ϊ�գ���");

			}
			if (null == user.getUserName()|| "".equals(user.getUserName())) {
				return HigherResponse.getResponseFailed("�û�������Ϊ��!!");

			}
			if (null == user.getPassWord()|| "".equals(user.getPassWord())) {
				return HigherResponse.getResponseFailed("���벻��Ϊ��!!");

			}
			User queryUserByUserNameAndPsw = userDao.queryUserByUserNameAndPsw(user);
			if(null == queryUserByUserNameAndPsw) {
				return HigherResponse.getResponseFailed("�û�����������󣡣���");
			}
			return HigherResponse.getResponseSuccess(queryUserByUserNameAndPsw);
		
		}


		@Override
		public HigherResponse<Object> pageQueryUser(Integer pageNum, Integer pageSize) {
			// ������ҳ
			PageHelper.startPage(pageNum, pageSize);
			// ���ò�ѯ�����û��ķ���
			List<User> queryAllUser = userDao.queryAllUser();
			PageInfo<User> pageInfo = new PageInfo<>(queryAllUser);
			if (null == pageInfo) {
				return HigherResponse.getResponseFailed("��ѯ����ʧ�ܣ�");
			} else {
				return HigherResponse.getResponseSuccess(pageInfo);
			}
		}

		
		@Override
		public HigherResponse<Object> pageQueryAUser(Integer pageNum, Integer pageSize) {
			// ������ҳ
							PageHelper.startPage(pageNum, pageSize);
							// ���ò�ѯ���й���Ա�ķ���
							List<User> queryAllAUser = userDao.queryAllAUser();
							PageInfo<User> pageInfo = new PageInfo<>(queryAllAUser);
							if (null == pageInfo) {
								return HigherResponse.getResponseFailed("��ѯ����ʧ�ܣ�");
							} else {
								return HigherResponse.getResponseSuccess(pageInfo);
							}
		}

		

		@Override
		public HigherResponse<User> cheakNameOrNumberExists(String val, String type) {
			if (null == val || "".equals(val)) {
				return HigherResponse.getResponseFailed("�����û������ֻ����벻��Ϊ�գ������ԣ�����");
			} 
			if (null == type || "".equals(type)) {
				return HigherResponse.getResponseFailed("�������쳣������");
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
				return HigherResponse.getResponseFailed(type+"��ע��,��������д������");
			}
			return HigherResponse.getResponseSuccess(type+"���ã�����");
		}


		@Override
		public HigherResponse<Boolean> register(User user) {
			//�ж��û��Ƿ�Ϊ��
			if(null == user) {
				HigherResponse.getResponseFailed("�������쳣������");
			}
			if(null == user.getUserName() || "".equals(user.getUserName())) {
				HigherResponse.getResponseFailed("�û�������Ϊ�գ�����");
			}
			if(null == user.getNumber() || "".equals(user.getNumber())) {
				HigherResponse.getResponseFailed("�ֻ����벻��Ϊ�գ�����");
			}
			if(null == user.getPassWord() || "".equals(user.getPassWord())) {
				HigherResponse.getResponseFailed("���벻��Ϊ�գ�����");
			}
			//�ж��û����Ƿ���ע��
			
			//�ж������Ƿ��Ѿ�ע��
			
			
			Boolean addOneUser = userDao.addOneUser(user);
			
			if(false == addOneUser) {
				return HigherResponse.getResponseFailed("ע��ʧ�ܣ�������ע�ᣡ����");
			}
			return HigherResponse.getResponseSuccess("ע��ɹ�������");
		}

		
		
		

		@Override
		public HigherResponse userLogin(String username, String psw, HttpSession session) {
			if (username == null || username.length() == 0) {
				return HigherResponse.getResponseFailed("�û�������Ϊ�գ���");

			}
			if (psw == null || psw.length() == 0) {
				return HigherResponse.getResponseFailed("���벻��Ϊ��!!");

			}
			User user = new User();
			user.setUserName(username);
			user.setPassWord(psw);
			User queryNameAndPsw = userDao.queryNameAndPsw(user);

			if (null == queryNameAndPsw) {
				return HigherResponse.getResponseFailed("�û��������ڣ�����������");
			}

			session.setAttribute("user",queryNameAndPsw);

			return HigherResponse.getResponseSuccess(queryNameAndPsw);
		}


		@Override
		public HigherResponse<Boolean> registerA(User user) {
			//�ж��û��Ƿ�Ϊ��
			if(null == user) {
				HigherResponse.getResponseFailed("�������쳣������");
			}
			if(null == user.getUserName() || "".equals(user.getUserName())) {
				HigherResponse.getResponseFailed("�û�������Ϊ�գ�����");
			}
			if(null == user.getNumber() || "".equals(user.getNumber())) {
				HigherResponse.getResponseFailed("�ֻ����벻��Ϊ�գ�����");
			}
			if(null == user.getPassWord() || "".equals(user.getPassWord())) {
				HigherResponse.getResponseFailed("���벻��Ϊ�գ�����");
			}
			
			//�ж��û����Ƿ���ע��
			
			//�ж������Ƿ��Ѿ�ע��
			
			
			Boolean addOneAUser = userDao.addOneAUser(user);
			
			if(false == addOneAUser) {
				return HigherResponse.getResponseFailed("ע��ʧ�ܣ�������ע�ᣡ����");
			}
			return HigherResponse.getResponseSuccess("ע��ɹ�������");
		}


		

		
}
