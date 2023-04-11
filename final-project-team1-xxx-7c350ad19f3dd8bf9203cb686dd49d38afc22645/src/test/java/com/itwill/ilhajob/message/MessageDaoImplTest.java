package com.itwill.ilhajob.message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.message.mapper.MessageMapper;
@SpringBootTest
class MessageDaoImplTest {
	
	@Autowired
	private MessageMapper messageMapper;
	
	//@Test
	void testCreate() {
		Message message1 = Message.builder().messageSeq(10)
						.messageTitle("빌드테스트")
						.messageContents("테스트입니다.")
						.messageDate(new Date())
						.userSeq(3)
						.appSeq(2)
						.build();
		messageMapper.createMessage(message1);
	}
	
	//@Test
	void testUpdate() {
		Message message2 = Message.builder().messageSeq(10)
						.messageTitle("빌드수정")
						.messageContents("수정")
						.messageSeq(7)
						.build();
		messageMapper.updateMessage(message2);
	}
	
	//@Test
	void testSelectMessageByUser() {
		System.out.println(messageMapper.findMessageOfUser(3));
	}
	
	//@Test
	void testSelectMessage() {
		System.out.println(messageMapper.findMessage(1));
	}
	//@Test
	void testMessageList() {
		System.out.println(messageMapper.findMessageList());
	}
	//@Test
	void testRemove() {
		messageMapper.removeMessageBySeq(7);
	}
	//@Test
	void testRemoveByUser() {
		messageMapper.removeMessageByUserSeq(1);
	}
}
