package com.itwill.guest.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class GuestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	GuestService guestService;
	
	
	
	@Test
	void testGuest_list() throws Exception {
		List<Guest> guestList = new ArrayList<Guest>();
		guestList.add(new Guest(1, null, null, null, null, null, null));
		guestList.add(new Guest(2, null, null, null, null, null, null));
		
		given(guestService.selectAll()).willReturn(new ArrayList<Guest>());
		
		mockMvc.perform(get("/guest_list"))
						.andExpect(status().isOk())
						.andExpect(forwardedUrl("/WEB-INF/views/guest_list.jsp"))
						.andDo(print());
		//static import  -->  ctrl+shift+o;
		verify(guestService).selectAll();
		
	}
	@Test
	void testGuest_viewIntegerModel() throws Exception {
		given(guestService.selectByNo(1)).willReturn(new Guest(0, null, null, null, null, null, null));
		mockMvc.perform(get("/guest_view").param("guest_no", "1"))
			.andExpect(status().isOk())//검증
			.andExpect(model().attributeExists("guest"))
			.andExpect(forwardedUrl("/WEB-INF/views/guest_view.jsp"))
			.andDo(print());
		
		verify(guestService).selectByNo(1);
	}

}
