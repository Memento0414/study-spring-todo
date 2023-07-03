package org.edupoll.repository.impl;


import org.apache.ibatis.session.SqlSession;
import org.edupoll.model.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OracleUserRepositoryByMybatis implements UserRepository{

	@Autowired
	SqlSession sqlSession;
	
	public void create (User user) {
		sqlSession.insert("users.create", user);
	}
	
	
	public User findById(String id) {
		
		return sqlSession.selectOne("users.findById", id);
	}
	
}