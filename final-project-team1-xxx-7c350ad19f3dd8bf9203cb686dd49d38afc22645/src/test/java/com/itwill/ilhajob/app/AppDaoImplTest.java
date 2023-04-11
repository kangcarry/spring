package com.itwill.ilhajob.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.app.mapper.AppMapper;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.recruit.Recruit;

@SpringBootTest
class AppDaoImplTest {
	
	@Autowired
	private AppMapper appMapper; 	
	
	
	/*@Test
	void testFindAppByUserSeq() {
		System.out.println(appMapper.findAppByUserSeq(2));
	}
*/	
	
	
	@Test
	void testCreateApp() {
		Recruit rc = new Recruit();
		rc.setRcSeq(3);
		Cv cv = new Cv();
		cv.setCvSeq(1);
		App app = App.builder().appSeq(1)
				.appStatus('G')
				.corpId("corp_03")
				.rc(rc)
				.cv(cv)
				.userSeq(3)
				.build();
		appMapper.insertApp(app);
	}
	
}
