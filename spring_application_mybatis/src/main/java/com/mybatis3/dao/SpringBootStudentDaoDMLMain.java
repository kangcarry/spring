package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(10000,"김강민","10000gmail.com",new Date());
		System.out.println("## rowCount:"+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0,"김수민","20000gmail.com",new Date());
		System.out.println("## rowCount:"+studentDao.insertStudentBySequence1(student2));
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3 = new Student(0,"스튜던트3","st3@gmail.com",new Date());
		System.out.println("## rowCount:"+studentDao.insertStudentBySequence2(student3));
		System.out.println("### pk-->"+student3.getStudId());
		System.out.println("### "+student3.getStudId()+"번 pk student: "
				+studentDao.findStudentById(student3.getStudId()));
		System.out.println("---------updateStudentById---------------------------");
		Student updateStudent = studentDao.findStudentById(4);
		updateStudent.setName("스튜던트4");
		updateStudent.setEmail("change@naver.com");
		updateStudent.setDob(new SimpleDateFormat("yyyy/mm/dd").parse("2020/02/02"));
		System.out.println("## update rowCount:"+studentDao.updateStudentById(updateStudent));
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println(studentDao.deleteStudentById(10000));
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("---------deleteStudentByNameLike---------------------");
	}
}