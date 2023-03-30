package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.jpa.relation.entity.Person;
@SpringBootApplication
class PersonRepositoryTest {
	@Autowired
	PersonRepository personRepository;
	@Test
	void test() {
		personRepository.save(Person.builder()
									.id(0L)
									.age(15)
									.name("하은").build());
		System.out.println(personRepository.findAll());
	}

}
