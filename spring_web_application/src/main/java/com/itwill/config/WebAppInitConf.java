package com.itwill.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * web.xml 설정을 대신할 클래스 /WebApplicationInitializer
 * - 톰캣실행시 기본설정
 */
public class WebAppInitConf /*implements WebApplicationInitializer */{
	/*
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.register(WebConfig.class);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet());
		dynamic.setLoadOnStartup(0);
		dynamic.addMapping("/");
		
	}
	*/
}
