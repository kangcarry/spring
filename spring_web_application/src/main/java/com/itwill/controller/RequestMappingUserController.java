package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingUserController {
	@RequestMapping("user/list")
	public String user_list() {
		return "forward:/WEB-INF/views/user/list.jsp";
	}
	@RequestMapping("user/view")
	public String user_view() {
		return "forward:/WEB-INF/views/user/view.jsp";
	}
	
}
