package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void categoryProductSaveAndRead() {
		/******case1[ManyToOne]******/
		/*
		Category category=Category.builder().code("C1").name("컴퓨터").build();
		categoryRepository.save(category);
		
		Product product1 = Product.builder().id(1L).name("손오공컴퓨터").price(100000).stock(100).category(category).build();
		Product product2 = Product.builder().id(1L).name("공룡컴퓨터").price(100000).stock(100).category(category).build();
		Product product3 = Product.builder().id(1L).name("동물컴퓨터").price(100000).stock(100).category(category).build();
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		System.out.println("-------------------------read---------------------------");
		System.out.println("Category:"+categoryRepository.findById(1L).get());
		System.out.println("Category--> ProductList :"+categoryRepository.findById(1L).get().getProducts());
		*/
		/******case2[OneToMany]******/
		
		Product product1 = Product.builder().id(1L).name("손오공컴퓨터").price(100000).stock(100).build();
		Product product2 = Product.builder().id(2L).name("공룡컴퓨터").price(100000).stock(100).build();
		Product product3 = Product.builder().id(3L).name("동물컴퓨터").price(100000).stock(100).build();
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		Category category=new Category("C1", "컴퓨터");		
		
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		category.getProducts().add(product3);
		
		categoryRepository.save(category);
	}
}
