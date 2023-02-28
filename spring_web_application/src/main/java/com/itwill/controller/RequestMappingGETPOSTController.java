package com.itwill.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingGETPOSTController {
//	@RequestMapping(method= RequestMethod.GET) 예전에 GetMapping 대신사용
	@GetMapping("/login")
	public String get_login_form() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
//	@RequestMapping(method= RequestMethod.POST)
	@PostMapping("/login")
	public String post_login_action(@RequestParam String id,
									@RequestParam (name = "password") String pass,
									HttpSession session) {
		System.out.println("### id 			parameter:"+id);
		System.out.println("### id password parameter:"+pass);
		boolean isLogin=true;
		if(isLogin) {
			session.setAttribute("sUserID", id);
		}
		return "forward:/WEB-INF/views/post_login_result.jsp";
	}
}
