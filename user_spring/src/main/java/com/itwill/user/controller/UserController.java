package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMissmatchException;
import com.itwill.user.exception.UserNotFoundException;
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
	
	@RequestMapping(value = "/user_write_form")
	public String user_write_form() throws Exception {
		String forward_path = "user_write_form";
		return forward_path;
	}
	
	@PostMapping("user_write_action")
	public String user_write_action(@ModelAttribute("fuser")User user,Model model) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
			forward_path = "redirect:user_view";
		}catch(ExistedUserException e) {
			model.addAttribute("msg",e.getMessage());
//			model.addAttribute("fuser",user);
			forward_path="user_write_form";
		}
		return forward_path;
	}
	@RequestMapping("user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@PostMapping("user_login_action")
	public String user_login_action(@ModelAttribute("fuser") User user,Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			forwardPath="user_main";
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="user_login_form";
		}catch (PasswordMissmatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="user_login_form";
		}
		return forwardPath;
	}
	
	@RequestMapping("user_view")
	public String user_view(HttpSession session,Model model) throws Exception {
		/************** login check **************/
		String forwardPath ="";
		User loginUser = null;
		try {
		if(session.getAttribute("sUserId")==null) {
			forwardPath = "user_login";
		}else {
			String userId = (String)session.getAttribute("sUserId");
			loginUser = userService.findUser(userId);
			model.addAttribute("loginUser",loginUser);
			forwardPath = "user_view";
		}}catch (ExistedUserException e) {
			model.addAttribute("msg",e.getMessage());
		}
		return forwardPath;
	}

	@PostMapping("user_modify_form")
	public String user_modify_form_post(HttpServletRequest request, Model model) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String forwardPath ="";
		User loginUser = null;
		if(session.getAttribute("sUserId")==null) {
			forwardPath = "user_lo gin";
		}else {
			String userId = (String)session.getAttribute("sUserId");
			loginUser = userService.findUser(userId);
			model.addAttribute("loginUser",loginUser);
			forwardPath = "user_modify_form";
		}
		return forwardPath;
	}
	@PostMapping("user_modify_action")
	public String user_modify_action_post(User loginuser) throws Exception {
		userService.update(loginuser);
		String forwardPath = "redirect:user_view";
		return forwardPath;
	}

	public String user_remove_action_post(HttpSession session) throws Exception {
		/************** login check **************/
		userService.remove(null);
		session.invalidate();
		String forwardPath = "";
		return forwardPath;
	}

	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

/******************GET방식요청시 guest_main redirection*******************/
	@GetMapping({"user_write_action"})
	public String user_get() {
		String forwardPath = "user_main";
		return forwardPath;
	}
	
/***************Local Exception Handler*************/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}

}
