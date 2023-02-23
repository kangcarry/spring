package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class GuestDaoImpljdbcTempleteTest {
	@Autowired
	GuestDao guestDao;
	@Test
	void testSelectAll() throws Exception {
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());	
		
	}
	@Disabled //테스트 성공
	@Test
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0, "kim", null, "kim@gmail.com", "gmail.com", "hello", "hi");
		System.out.println(guestDao.insertGuest(guest));
	}
	@Test
	@Disabled //테스트 실패 의문
	void testSelectByNo() throws Exception {
		System.out.println(guestDao.selectByNo(2));
	}
	@Disabled
	@Test
	void testDeleteGuest() throws Exception {
		System.out.println(guestDao.deleteGuest(0));
	}
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest = new Guest(5, "업뎃", null, "update@gmail.com", "update.com", "업데이트", "내용");
		System.out.println(guestDao.updateGuest(updateGuest));
	}

}
