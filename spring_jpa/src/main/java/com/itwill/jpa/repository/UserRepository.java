package com.itwill.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByName(String name);
	List<User> findByEmail(String email);
	/*
	List<User> getByName(String name);
	List<User> searchByName(String name);
	List<User> readByName(String name);
	*/
	
	
	List<User> findUserByName(String name);
	List<User> findByNameAndEmail(String name,String email);
	List<User> findByNameOrEmail(String name,String email);
	
	List<User> findFirst2ByName(String name);
	List<User> findTop2ByName(String name);
	
	List<User> findByIdAfter(Long id);
	List<User> findByIdBetween(Long id1,Long id2);
	
	List<User> findByCreateAtGreaterThan(LocalDateTime createdAt);
	List<User> findByCreateAtGreaterThanEqual(LocalDateTime createdAt);
	
	@Query(value="select * from users where name=?1",nativeQuery =true)
	List<User> findByNameSQL(String name);
}
