package com.itwill.ilhajob.dao;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.corp.CorpDao;
@SpringBootTest
class CorpDaoTest {
	@Autowired
	CorpDao corpDao;
	
	void testInsertCorp() {
	}

	@Test
	void testSelectById() throws Exception {
		System.out.println(corpDao.selectById("corp_13"));
	}

	void testSelectAll() {
	}

	void testUpdateCorp() {
	}

	void testDeleteCorp() {
	}

}
