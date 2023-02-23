package com.itwill.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.jdbc.User;
import com.itwill.user.dao.jdbc.UserDao;

@SpringBootApplication
@SpringBootTest
class UserDaoImplTest {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	void contextLoad() {
		System.out.println(applicationContext);
	}
	
	
	
	@Test
	void testCreate() throws Exception {
		User user= new User("test99","test99","테스트9","test99@test.com");
		assertEquals(userDao.create(user), 1);
	}
	

	@Test
	void testFindUser() throws Exception {
		User user = userDao.findUser("test88");
		assertNotNull(user);
		assertNotNull(user.getName());
		assertNotNull(user.getUserId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getEmail());
		System.out.println(user);
	}



	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
