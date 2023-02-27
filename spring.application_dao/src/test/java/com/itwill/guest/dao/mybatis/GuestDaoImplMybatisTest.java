package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@SpringBootTest
class GuestDaoImplMybatisTest {
	@Autowired
	GuestDao guestDao;
	
	@Test
	void testSelectAll() throws Exception {
		System.out.println(guestDao.selectAll());
	}
	@Disabled //안됨
	void testSelectByNo() throws Exception {
		System.out.println(guestDao.selectByNo(211));
	}
	@Disabled //안됨
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0, "test01", null, "test01", "test01", "hji", "hello");
		System.out.println(guestDao.insertGuest(guest));
	}
		
	@Disabled
	void testUpdateGuest() {
		fail("Not yet implemented");
	}
	@Disabled
	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
