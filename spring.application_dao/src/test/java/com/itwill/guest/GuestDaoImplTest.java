package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class GuestDaoImplTest {
	@Autowired
	GuestDao guestDao;

	@Test
	void contextLoad() {
	}
	
	@Test
	void testSelectAll() throws Exception {
		System.out.println(guestDao.selectAll());
	}

	@Test
	void testSelectByNo() throws Exception {
		System.out.println(guestDao.selectByNo(0));
	}

//	@Test
//	void testInsertGuest() {
//	}
//
//	@Test
//	void testUpdateGuest() {
//	}
//
//	@Test
//	void testDeleteGuest() {
//	}

}
