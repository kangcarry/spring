package com.itwill.guest.dao.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwill.guest.dao.jdbc.GuestSQL;
import com.itwill.guest.dao.mybatis.mapper.GuestMapper;

@Repository
@MapperScan(basePackages = "com.itwill.guest.dao.mybatis.mapper" )
public class GuestDaoImplMybatis implements GuestDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Guest> selectAll() {
		return sqlSession.selectList("selectAll");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSession.selectOne("selectByNo");
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return sqlSession.insert("insertGuest",guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
