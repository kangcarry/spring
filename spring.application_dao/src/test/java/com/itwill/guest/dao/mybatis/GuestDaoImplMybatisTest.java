package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

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
	private GuestDao guestDao;
	
	@Test
	void testSelectAll() throws Exception {
		System.out.println(guestDao.selectAll());
	}
	@Disabled
	void testSelectByNo() {
		fail("Not yet implemented");
	}
	@Disabled
	void testInsertGuest() {
		fail("Not yet implemented");
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
