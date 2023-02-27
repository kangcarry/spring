package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * StudentMapper 인터페이스의 와 같은위치에 StudentMapper.xml을 위치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	
	public Student  findStudentById(Integer studId);
	public List<Student> findAllStudents();
	public String findStudentNameById(Integer studId);
	public List<String> findStudentNameList();
	public int insertStudent(Student student);
	public int insertStudentBySequence1(Student student);
	
	/*
	<insert id="insertStudentBySequence2" 
			parameterType="com.mybatis3.domain.Student">
		<selectKey order="BEFORE"  resultType="int"  keyProperty="studId" >
			select students_stud_id_seq.nextval from dual
		</selectKey>
		insert into students(stud_id,name,email,dob)
			values (#{studId},#{name},#{email},#{dob})
	</insert>
	 */
	@SelectKey(	statement = "select students_stud_id_seq.nextval from dual",
				before = true,
				keyProperty ="studId",
				resultType = Integer.class)
	@Insert("insert into students(stud_id,name,email,dob) values (#{studId},#{name},#{email},#{dob})")
	public int insertStudentBySequence2( Student student);
	
	public int updateStudentById(Student student);
	public int deleteStudentById(Integer studId);
	
	
	public Student findStudentByIdWithAddress(Integer studId);
	
	
	/*
	<select 	id="findStudentByIdWithCourses" 
	 			parameterType="java.lang.Integer"
	 			resultMap="studentWithCoursesResultMap">
	 	select 	s.stud_id,s.name as student_name,email,dob,
	 			c.course_id,c.name as course_name,description,start_date,end_date 
		from students s 
		join course_enrollment ce
		on s.stud_id = ce.stud_id
		join courses c
		on ce.course_id=c.course_id where s.stud_id=#{studId}
	 </select>
	 */
	@ResultMap("studentWithCoursesResultMap")
	@Select("	select 	s.stud_id,s.name as student_name,email,dob,"
			+ "	 			c.course_id,c.name as course_name,description,start_date,end_date "
			+ "		from students s"
			+ "		join course_enrollment ce"
			+ "		on s.stud_id = ce.stud_id"
			+ "		join courses c"
			+ "		on ce.course_id=c.course_id where s.stud_id=#{studId}")
	public Student findStudentByIdWithCourses(@Param("studId") Integer studId);
}

