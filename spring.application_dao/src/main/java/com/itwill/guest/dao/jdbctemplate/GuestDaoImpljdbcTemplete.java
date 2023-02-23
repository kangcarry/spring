package com.itwill.guest.dao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwill.guest.dao.jdbc.GuestSQL;

@Repository
public class GuestDaoImpljdbcTemplete implements GuestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}
	
	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT, guest.getName(),
														 guest.getEmail(),
														 guest.getHomepage(),
														 guest.getTitle(),
														 guest.getContent());
	}
	
	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, new Object[] {no},new BeanPropertyRowMapper<Guest>(Guest.class));
	}
	
	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
