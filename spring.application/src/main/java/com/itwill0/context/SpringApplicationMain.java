package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.itwill.product.ProductService;
@Component("productService")
public class SpringApplicationMain {
	
	public static void main(String[] args) {
		/*
		 * Spring Container객체생성
		 * 		- ApplicationContext[BeamFactory]객체생성
		 */
		
		/*
		 *	1. Spring Bean설정파일을 읽어서 SpringContainer객체생성 
		 */
		System.out.println("----------------ApplicationContext생성시작-----------------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");
		System.out.println("----------------ApplicationContext생성끝-----------------");
		
		/*
		 * 	2. Spring Container 객체[ApplicationContext객체]로부터
		 * 		productService 아이디객체 참조얻기
		 */
		
		ProductService productService= (ProductService) applicationContext.getBean("productService");
	
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(0));
		System.out.println("-------------subgketib 객체-----------------");
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
	}
	
}
