package com.itwill.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.SpringJpaApplication;
import com.itwill.jpa.SpringJpaApplicationTests;
import com.itwill.jpa.entity.User;
@SpringBootTest
@Transactional //테스트 후 무조건 롤백
class UserRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	UserRepository userRepository;
	@Test
	void users_crud() {
		/*****************insert****************/
		User user1 = new User("이승기", "leeseunggi@gmail.com",new Date(),LocalDateTime.now());
		User user2 = new User("리승기", "leeseunggi1@gmail.com",new Date(),LocalDateTime.now());
		User user3 = new User("하승기", "leeseunggi2@gmail.com",new Date(),LocalDateTime.now());
		User saveUser1 = userRepository.save(user1);//save = insert
		User saveUser2 = userRepository.save(user2);//save = insert
		User saveUser3 = userRepository.save(user3);//save = insert
		System.out.println(">>>saveUser1:"+saveUser1);
		System.out.println(">>>saveUser2:"+saveUser2);
		System.out.println(">>>saveUser3:"+saveUser3);
		/*****************find****************/
		Optional<User> optionalUser1 = userRepository.findById(1L);
		if(optionalUser1.isPresent()) {
			User findUser1 = optionalUser1.get();
			System.out.println(">>> findUser1"+findUser1);
		}
		/****************selectAll***************/
		List<User> userList = userRepository.findAll();
		System.out.println(">>> userList :"+userList);
		/****************update***************/
		Optional<User> optionalUser2 = userRepository.findById(3L);
		if(optionalUser2.isPresent()) {
			User findUser2 = optionalUser2.get();
			findUser2.setName("2승기");
			findUser2.setEmail("2seunggi1@gmail.com");
			findUser2.setUpdatedAt(LocalDateTime.now().plusDays(1L));
			User updateUser2 = userRepository.save(findUser2);
			System.out.println(">>>updateUser2:"+updateUser2);
		}
		/****************delete***************/
		userRepository.deleteById(3L);
		userRepository.delete(saveUser2);
		
		userList = userRepository.findAll();
		System.out.println(">>> userList :"+userList);
	}
	@Test
	void select() {
		/*
		User user1 = new User("이승기", "leeseunggi@gmail.com",new Date(),LocalDateTime.now());
		User user2 = new User("리승기", "leeseunggi1@gmail.com",new Date(),LocalDateTime.now());
		User user3 = new User("하승기", "leeseunggi2@gmail.com",new Date(),LocalDateTime.now());
		User saveUser1 = userRepository.save(user1);//save = insert
		User saveUser2 = userRepository.save(user2);//save = insert
		User saveUser3 = userRepository.save(user3);//save = insert
		System.out.println(">>findByname :"+ userRepository.findByName("이승기")); 
		System.out.println(">>findByEmail :"+ userRepository.findByEmail("leeseunggi1@gmail.com"));
		
		System.out.println(">>findByNameAndEmail :"+ userRepository.findByNameAndEmail("김경호1","guard1@gmail.com")); 
		System.out.println(">>findByNameOrEmail :"+ userRepository.findByNameOrEmail("김경호3","guard2@gmail.com")); 
		
		System.out.println(">>findFirst2ByName :"+ userRepository.findFirst2ByName("김경호11"));
		System.out.println(">>findTop2ByName :"+ userRepository.findTop2ByName("김경호11"));
		
		System.out.println(">>findByIdAfter :"+ userRepository.findByIdAfter(7L));
		System.out.println(">>findByIdBetween :"+ userRepository.findByIdBetween(7L,12L))
*/
		//System.out.println(">>findByCreateAtGreaterThan :"+ userRepository.findByCreateAtGreaterThan(LocalDateTime.now()));
		//System.out.println(">>findByCreateAtGreaterThanEqual :"+ userRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now()));
		System.out.println(">>findByNameSQL :"+ userRepository.findByNameSQL("김경호11"));
	
		
	}
}
