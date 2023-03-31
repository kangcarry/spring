package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.Provider;
class ProviderREpositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	ProviderREpository providerRepository;
	@Autowired
	ProductRepository productRepository;
	
	//@Test
	void providerProductSaveRead() {
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerRepository.save(provider);
		
		Product product = new Product();
		product.setName("삼성책");
		product.setPrice(9000);
		product.setStock(100);
		
		Product product1 = new Product();
		product1.setName("삼성책1");
		product1.setPrice(4500);
		product1.setStock(100);
		/*****연관설정 Product-->Provider****/
		product.setProvider(provider);
		product1.setProvider(provider);
		/**********************************/
		productRepository.save(product);
		productRepository.save(product1);
		
		
		System.out.println("Provider:"+providerRepository.findById(1L).get());
		System.out.println("Provider--> ProductList"+providerRepository.findById(1L).get().getProductList());
		
		
	}
	
	/*****************case1 CascadeType.PERSIST****************/
	@Test
	void providerProductSaveAndReadCascadeTypePERSIST(){
		Provider provider = new Provider("한빛미디어");
		
		Product product1 = new Product("파이썬", 10000, 20);
		Product product2 = new Product("AI", 30000, 10);
		Product product3 = new Product("코틀린", 70000, 30);
		
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));
		
		providerRepository.save(provider);
	}
	
}
