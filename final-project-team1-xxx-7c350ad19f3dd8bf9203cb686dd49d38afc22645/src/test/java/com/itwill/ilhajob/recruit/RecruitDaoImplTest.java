package com.itwill.ilhajob.recruit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

@SpringBootTest
class RecruitDaoImplTest {

	@Autowired
	private RecruitMapper recruitMapper;
	
	@Disabled
	@Test
	void testInsertRecruit() {
		Corp corp = new Corp();
		corp.setCorpId("DBtest6");
		//Recruit recruit = new Recruit(0, "테스트", "테스트", "테스트", "테스트", 0, new Date(), new Date(), 0, corp);
		
		//recruitMapper.insertRecruit(recruit);
	}

	//@Disabled
	@Test
	void testFindByCorpId() {
		Corp corp = new Corp();
		corp.setCorpId("DBtest6");
		System.out.println(recruitMapper.findByCorpId(corp));
		
	}

	@Disabled
	@Test
	void testFindByJob() {
		System.out.println(recruitMapper.findByJob("2"));
	}

	@Disabled
	
	@Test
	void testFindBySeq() {
		System.out.println(recruitMapper.findBySeq(4));
	}

	@Disabled
	@Test
	void testUpdateBySeq() {
		Corp corp = new Corp();
		corp.setCorpId("DBtest6");
		//Recruit recruit = new Recruit(10, "업데이트", "업데이트", "업데이트", "업데이트", 1000, new Date(), new Date(), 0, corp);
		//System.out.println(recruitMapper.updateBySeq(recruit));
	}

	@Disabled
	@Test
	void testDeleteBySeq() {
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("rcSeq", 10);
    	paramMap.put("corpId", "DBtest6");
		System.out.println(recruitMapper.deleteBySeq(paramMap));
	}

}
