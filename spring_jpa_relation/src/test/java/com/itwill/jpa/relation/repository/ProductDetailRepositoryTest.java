package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.jpa.relation.SpringJpaRelationApplication;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

@SpringBootTest
class ProductDetailRepositoryTest extends SpringJpaRelationApplication{
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProductRepository productRepository;
	
	
	//jpa : save ()pk가 없으면 create하고 있으면 update한다
	@Test
	void productDetailProductSaveRead() {
		Product product = new Product();
		product.setName("스프링입문책");
		product.setPrice(80000);
		product.setStock(100);
		productRepository.save(product);
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription("아주좋은책이에요!!");
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);
		
		System.out.println("----------------read----------------");
		ProductDetail productDetail2 = productDetailRepository.findById(1L).get();
		System.out.println(">>>productDetail2"+productDetail2);
		
		System.out.println(">>>product2"+productDetailRepository.findById(1L).get().getProduct());
		
	}

}
