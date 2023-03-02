package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
@Controller
public class GuestController {
	@Autowired
	private GuestDao guestDao;
	
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
	
	@RequestMapping("/guest_list")
	public String guest_list(HttpServletRequest request) throws Exception {
		String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		List<Guest> guestList = guestDao.selectAll();
		request.setAttribute("guestList", guestList);
		return forwardPath;
	}
	
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "redirect:guest_error";
		return forwardPath;
	}
	@GetMapping("/guest_modify_action_get")
	public String guest_modify_action_get(@ModelAttribute Guest guest) throws Exception {
		guestDao.updateGuest(guest);
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest) throws Exception {
		guestDao.updateGuest(guest);
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
		return forwardPath;
	}
	
	@GetMapping("/guest_modify_get")
	public String guest_modify_get(HttpServletRequest request) throws Exception {
		int guest_no = Integer.parseInt((String) request.getAttribute("guest_no"));
		Guest guest = guestDao.selectByNo(guest_no);
		request.setAttribute("guest", guest);
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_modify_get")
	public String guest_modify_form(HttpServletRequest request) throws Exception {
		int guest_no = Integer.parseInt((String) request.getAttribute("guest_no"));
		Guest guest = guestDao.selectByNo(guest_no);
		request.setAttribute("guest", guest);
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}

	public String guest_remove_action_get() {
		String forwardPath = "";
		return forwardPath;
	}

	
	public String guest_remove_action() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_view() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_write_action_get() {
		String forwardPath = "";
		return forwardPath;
	}

	public String guest_write_action() {
		String forwardPath = "";

		return forwardPath;
	}

	
	public String guest_write() {
		String forwardPath = "";
		return forwardPath;

	}

}
