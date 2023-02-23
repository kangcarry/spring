
package com.itwill.guest.dao.jdbctemplate;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = 
				(JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A.JdbcTemplate:"+jdbcTemplate);
		System.out.println("B.JdbcTemplate DataSource:"+jdbcTemplate.getDataSource());
		//System.out.println("C.JdbcTemplate DataSource Connection:"+jdbcTemplate.getDataSource().getConnection());
		
		System.out.println("1. JdbcTemplate객체얻기");
		/**********************************************************
		 * select --> queryForObject 반환타입[String,Wrapper,DTO]
		 **********************************************************/
		/*
		 * queryForObject[반환타입 Guest]
		 */
		String selectDtoSql="select * from guest where guest_no=?";
		Object[] paramArray1 = {263};
		Object[] paramArray2 = new Object[]{263};
		
		/*
		 << BeanPropertyRowMapper 클래스 >>
		 	 ResultSet객체로부터 데이타를 컬럼이름으로 get해서 
		 	 Guest객체생성후 테이블컬럼이름과 동일한이름의 
		 	 Guest객체의 property(멤버변수)에 대입해주는클래스 
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper=
				new BeanPropertyRowMapper<Guest>(Guest.class);
		
		
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql,
												 new Object[]{264},
												 new int[] {Types.INTEGER},
												 guestBeanPropertyRowMapper);
		System.out.println("--> queryForObject[Guest]:"+guest);
		/*
		 * queryForObject[반환타입 String Wrapper]
		 */
		String selectStringSql="select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql,
														new Object[] {264} ,
														new int[] {Types.INTEGER},
														String.class);
		System.out.println("--> queryForObject[String]:"+guest_name);
		
		
		/*************************************************************
		 * select --> query 반환타입[List<Dto>]
		 ************************************************************/
		/*
		 * query [반환타입 List<Guest>]
		 */
		String selectDtoListSql="select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql,guestBeanPropertyRowMapper);
		System.out.println("--> query[List<Guest>]:"+guestList);
		/*************************************************************
		 * select --> queryForList 반환타입[List<String,Wrapper>]
		 ************************************************************/
		String selectStringListSql="select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("--> queryForList[List<String>]:"+guest_nameList);
		
		
		/*****************************************************************
		 * select --> queryForList 반환타입[LIST<Map><String,Object>]
		 *****************************************************************/
		String selectMapSql="select * from guest where guest_no=?";
		Map rowMap = jdbcTemplate.queryForMap(selectMapSql,new Object[] {264},new int[] {Types.INTEGER});
		System.out.println("--> queryForMap 반환타입[Map<String,Object>]:"+rowMap);
		
		String selectMapListSql="select * from guest";
		List rowMapList = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("--> queryForMap 반환타입[List<Map<String,Object>>]:"+rowMapList);
		
		/*****************************************************************
		 * DML(update,delete,insert) --> update 반환타입[ rowCount(int) ]
		 *****************************************************************/
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql,"김수미","sumi@gmail.com","www.sumi.com","간장게장","만들기..");
		System.out.println("insert row count:"+rowCount);
		String updateSql="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount=jdbcTemplate.update(updateSql,"김우미","umi@umi.com","www.umi.com","새우장","먹기",281);
		System.out.println("update row count:"+rowCount);
		String deleteSql="delete from guest where guest_no=?";
		rowCount=jdbcTemplate.update(deleteSql,263);
		System.out.println("delete row count:"+rowCount);

	}

}