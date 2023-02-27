package com.mybatis3.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentBasicMapper {
	/*
	 * <select id="studentList" resultType="com.mybatis3.domain.Student">
		select stud_id as studId,name,email,dob from students
		</select>
	 */
	@Select("select stud_id as studId,name,email,dob from students where stud_id = #{studId}")
	public Student findStudent(@Param(value = "studId")Integer studId);
	
	public List<Student> studentList();
}
