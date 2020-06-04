package com.hzb.entity;



public class User {
	
	public User() {
		
	}
	
	

	




	public User(Integer id, int role, String userName, String passWord, String number, String sex, String address) {
		super();
		this.id = id;
		this.role = role;
		this.userName = userName;
		this.passWord = passWord;
		this.number = number;
		this.sex = sex;
		this.address = address;
	}








	private Integer id;
	private int role;
	private String userName;
	private String passWord;
	private String number;
	private String sex;
	private String address;
	public Integer getId() {
		return id;
	}






	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public String getNumber() {
		return number;
	}






	public void setNumber(String number) {
		this.number = number;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getPassWord() {
		return passWord;
	}






	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}






	public String getSex() {
		return sex;
	}






	public void setSex(String sex) {
		this.sex = sex;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", userName=" + userName + ", passWord=" + passWord + ", number="
				+ number + ", sex=" + sex + ", address=" + address + "]";
	}






	















	
	
	
}
