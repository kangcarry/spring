package com.itwill.user.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplMybatis implements UserDao{
	@Autowired
	SqlSession sqlSession;
	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert(null);
	}
	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
