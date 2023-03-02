package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("user_write_form")
	public String user_write_form() throws Exception {
		String forward_path = "user_write_form";
		return forward_path;
	}
	
	@PostMapping("user_write_action_post")
	public String user_write_action_post(User fuser) throws Exception {
		userService.create(fuser);
		String forward_path = "user_view";
		return forward_path;
	}
	@RequestMapping("user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@PostMapping("user_login_action")
	public String user_login_action_post(User fuser,HttpServletRequest request) throws Exception {
		int loginNo = userService.login(fuser.getUserId(), fuser.getPassword());
		String forwardPath = "";
		HttpSession session = request.getSession();
		String msg1="아이디가 불일치합니다";
		String msg2="비밀번호가 불일치합니다";
		if(loginNo==0) {
			request.setAttribute("msg1",msg1);
			forwardPath="user_login_form";
		}else if(loginNo==1) {
			request.setAttribute("msg2",msg2);
			forwardPath="user_login_form";
		}else if(loginNo==2) {
			session.setAttribute("sUserId", fuser.getUserId());
			forwardPath="user_main";
		}
		
		return forwardPath;
	}
	
	@RequestMapping("user_view")
	public String user_view(HttpServletRequest request,Model model) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String forwardPath ="";
		User loginUser = null;
		if(session.getAttribute("sUserId")==null) {
			forwardPath = "user_login";
		}else {
			loginUser = userService.findUser((String)session.getAttribute("sUserId"));
			model.addAttribute(loginUser);
			forwardPath = "user_view";
		}
		return forwardPath;
	}


	public String user_modify_form_post() throws Exception {
		/************** login check **************/

		String forwardPath = "";

		return forwardPath;
	}

	public String user_modify_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_remove_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_action_get() {
		String forwardPath = "";
		return forwardPath;
	}


}
