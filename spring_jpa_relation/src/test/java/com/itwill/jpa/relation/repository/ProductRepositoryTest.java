package com.itwill.jpa.relation.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
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
	@Test
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
	@Test
	void productProviderSaveRead() {
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerREpository.save(provider);
		
		Product product = new Product();
		product.setName("삼성책");
		product.setPrice(9000);
		product.setStock(100);
		product.setProvider(provider);
		
		productRepository.save(product);
		
		System.out.println("Product:"+productRepository.findById(2L).get());
		System.out.println("Produ"
				+ "ct-->Provider:"+productRepository.findById(2L).get().getProvider());
		
		
		
	}
	
}
