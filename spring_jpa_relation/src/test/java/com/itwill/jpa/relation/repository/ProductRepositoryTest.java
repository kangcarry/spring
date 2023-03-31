package com.itwill.jpa.relation.repository;

import java.time.LocalDateTime;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;
import com.itwill.jpa.relation.entity.Provider;

@SpringBootTest
class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProviderREpository providerREpository;
	@Autowired
	CategoryRepository categoryRepository;
	//@Test
	void productSaveAndUpdate() {
		Product product=Product.builder()
						.name("JPA일주일만하면")
						.price(3000)
						.stock(1000)
						.build();
		productRepository.save(product);
		
		product.setName("JSP하루만하면");
		productRepository.save(product);
		
	}
	
	//@Test
	void productProductDetailSaveRead() {
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
		System.out.println(">>>productDetail"+productDetailRepository.findById(1L).get());
		System.out.println(">>>product"+productDetailRepository.findById(1L).get().getProduct());
	}
	//@Test
	void productProviderSaveRead() {
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerREpository.save(provider);
		
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
		
		productRepository.save(product);
		productRepository.save(product1);
		
		/******연관설정 Provider-->Product*****/
		//provider.getProductList().add(product);
		//provider.getProductList().add(product1);
		
		providerREpository.save(provider);
		
		System.out.println("Product:"+productRepository.findById(2L).get());
		System.out.println("Product-->Provider:"+productRepository.findById(2L).get().getProvider());
		System.out.println("Product-->Provider-->ProductList:"+productRepository.findById(2L).get().getProvider().getProductList());
		
	}
		@Test
		void productCategorySaveAndRead() {
			/******case1[ManyToOne]******/
			Category category=Category.builder().code("C1").name("컴퓨터").build();
			categoryRepository.save(category);
			/*
			Product product1 = Product.builder().id(1L).name("손오공컴퓨터").price(100000).stock(100).category(category).build();
			Product product2 = Product.builder().id(1L).name("공룡컴퓨터").price(100000).stock(100).category(category).build();
			Product product3 = Product.builder().id(1L).name("동물컴퓨터").price(100000).stock(100).category(category).build();
			
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			
			System.out.println("-------------------------read---------------------------");
			System.out.println("product:"+productRepository.findById(3L).get());
			System.out.println("product--> Category :"+productRepository.findById(3L).get().getCategory());
			*/
		}
}
