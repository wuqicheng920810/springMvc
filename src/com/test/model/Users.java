package com.test.model;


public class Users {
	
	private Integer id;
	
	private String LoginName;

	private String passWord;
	
	private Integer rights_id;
	
	private Integer login_num;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getRights_id() {
		return rights_id;
	}

	public void setRights_id(Integer rights_id) {
		this.rights_id = rights_id;
	}

	public Integer getLogin_num() {
		return login_num;
	}

	public void setLogin_num(Integer login_num) {
		this.login_num = login_num;
	}




}
