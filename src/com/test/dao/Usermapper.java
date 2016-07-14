package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.Users;

@Repository("userMapper")
public interface Usermapper {
	
	public  void insertUser(Users u);

	public int fundByName(String name);
	
	public Users userLogin(Users u);
}
