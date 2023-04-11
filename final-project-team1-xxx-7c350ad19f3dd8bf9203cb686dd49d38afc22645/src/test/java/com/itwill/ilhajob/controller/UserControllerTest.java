package com.itwill.ilhajob.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	@Test
	void testGuest_list() throws Exception{
		List<User> guestList=new ArrayList<User>();
		guestList.add(new User());
		guestList.add(new User());
		
		
		mockMvc.perform(get("/guest_list"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/views/guest_list.jsp"))
		.andDo(print());
		// static import --> ctrl + shitft +o
	}
	@Test
	void testGuest_viewIntegerModel()throws Exception {
		given(userService.findUser("")).willReturn(new User());
		mockMvc.perform(get("/guest_view").param("guest_no","1"))
			.andExpect(status().isOk())//검증시작
			.andExpect(model().attributeExists("guest"))
			.andExpect(forwardedUrl("/WEB-INF/views/guest_view.jsp"))
			.andDo(print());
		verify(userService).findUser("");
	}
	
	

}





