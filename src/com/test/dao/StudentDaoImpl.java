/*package com.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.model.Student;

@Repository("studengDao")
public class StudentDaoImpl extends SqlSessionDaoSupport {
	
	public Student test1() throws Exception{
		System.out.println("1233");
		SqlSession sqlsession=this.getSqlSession();
		Student st= sqlsession.selectOne("test.fundByID",99);
		return st;
	}
	

}
*/