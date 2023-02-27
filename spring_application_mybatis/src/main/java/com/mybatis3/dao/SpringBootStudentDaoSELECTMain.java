package com.mybatis3.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;

@SpringBootApplication
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootStudentDaoSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoSELECTMain.class, args); //빈객체 사용하기위해 컨테이너 생성
		SqlSession sqlSession = appicationContext.getBean(SqlSession.class);  //빈객체 생성
		StudentDao studentDao =appicationContext.getBean(StudentDao.class);
		
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(1));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("---------findStudentNameById-------------------------");
		System.out.println(studentDao.findStudentNameById(4));
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println(studentDao.findStudentNameList());
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		
		
	}
}
