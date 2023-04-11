package com.itwill.ilhajob.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.user.mapper.UserMapper;

@SpringBootTest
class UserDaoImplTest {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDao userDao;
	
	@Disabled
	@Test
	void testCreate() {
		User user = User.builder().userSeq(5)
		.userAge(70)
		.userPassword("1111")
		.build();
		System.out.println(user);
		
		userMapper.create(user);
	}
	
	@Disabled
	@Test
	void testUpdate() {
		User user = User.builder().userSeq(5).userAddress("서울시 강남구")
		.userAge(70)
		.userPassword("1111")
		.userCareer("무")
		.userEmail("test@test.com")
		.userFinalEducation("초졸")
		.userImage("default.jpg")
		.userLanguage("한국어")
		.userName("아무개")
		.userPhone("없음")
		.userSex("중성")
		.userSkills(null)
		.userStatus("0")
		.snsType("0")
		.snsId("0")
		.build();
		userMapper.update(user);
	}
	
	@Disabled
	@Test
	void testRemove() {
		userMapper.remove("test@test.com");
	}
	
	@Disabled
	@Test
	void testFindUser() {
		System.out.println(userMapper.findUser("test1@test.com"));
	}

	@Disabled
	@Test
	void testExistedUser() {
		System.out.println(userMapper.existedUser("test1@test.com"));
	}
	
	/*
	 * @Disabled
	 * 
	 * @Test void testFindBySnsId() { User user =
	 * User.builder().snsType("1").snsId("1").build();
	 * System.out.println(userMapper.findBySnsId(user)); }
	 */
	
	//@Disabled
	@Test
	void testFindExpAwardsEduByUserSeq() throws Exception {
		System.out.println(userDao.findExpAwardsEduList(3));
	}
	
	//@Disabled
	@Test
	void testFindAppByUserSeq() throws Exception {
		System.out.println(userDao.findAppList(2));
	}

}
