package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.Right;
import com.test.model.UserRigthRote;
import com.test.model.Users;
@Repository("userrightMapper")
public interface UserRigthRotemapper {
	public List<UserRigthRote> findUrl(Users u);
}
