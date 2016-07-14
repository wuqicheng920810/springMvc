package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.Right;
import com.test.model.Users;
@Repository("rightMapper")
public interface Rightmapper {
	
	public List<Right> findUrl();
	
	public List<Right> findByRote(int uid);
    
	public List<Right> findRoteList();
	
	public List<Right> findRoteListByfatherId(int id);
}
