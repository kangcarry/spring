package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.guest.dao.jdbc.Guest;
import com.itwill.guest.dao.jdbc.GuestDao;
@SpringBootTest
@SpringBootApplication
class GuestDaoImplTest {
	@Autowired
	GuestDao guestDao;

	@Test
	void contextLoad() {
	}
	
	@Test
	void testSelectAll() throws Exception {
		
		System.out.println(guestDao.selectAll());
		assertEquals(guestDao.selectAll(),null);
		assertEquals(guestDao.selectAll().size(),0);
		assertNotNull(guestDao.selectByNo(196));
		assertSame(guestDao.selectByNo(121).getGuest_no(),121);
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
	}
	
	@Test
	void testSelectByNo() throws Exception {
		assertNull(guestDao.selectByNo(19324246));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(),"요셉짱");
		System.out.println(guestDao.selectByNo(196));
	}
	
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest= new Guest(0,"테스트",null,"test@gmail.com","test.com","타이틀","컨텐트");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
	}
	
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest= new Guest(263,"테스트수정",null,"testchange@gmail.com","testchange.com","타이틀수정","컨텐트수정");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if(updateRowCount!=1) {
			fail("update 실패");
		}
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
