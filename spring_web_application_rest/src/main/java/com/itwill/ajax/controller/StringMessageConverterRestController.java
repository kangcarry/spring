package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringMessageConverterRestController {
	@ResponseBody
	@GetMapping(value = "/response_string2",
				produces = "text/html;charset=UTF-8")
	public String response_String2() {
		return "<h3>hello string for ajax request[한글]</h3>";
	}
	
	
}
