package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		String forwardPath = "guest_main";
		return forwardPath;
	}
	
	@RequestMapping("/guest_list")
	public String guest_list(Model model) throws Exception {
		List<Guest> guestList = guestDao.selectAll();
		model.addAttribute("guestList", guestList);
		String forwardPath = "guest_list";
		return forwardPath;
	}
	
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "guest_error";
		return forwardPath;
	}

	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest) throws Exception {
		guestDao.updateGuest(guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}

	@RequestMapping("/guest_modify_form")
	public String guest_modify_form(Guest guest,Model model) throws Exception {
		model.addAttribute(guest);
		String forwardPath = "guest_modify_form";
		return forwardPath;
	}

	@PostMapping("/guest_remove_action")
	public String guest_remove_action(Guest guest) throws Exception {
		guestDao.deleteGuest(guest.guest_no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}

	@RequestMapping("/guest_view")
	public String guest_view(Guest guest,Model model) throws Exception {
		int no = guest.guest_no;
		model.addAttribute(guestDao.selectByNo(no));
		String forwardPath = "guest_view";
		return forwardPath;
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(Guest guest) throws Exception {
		guestDao.insertGuest(guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		String forwardPath = "guest_write_form";
		return forwardPath;

	}
	@GetMapping(value= {"guest_modify_form","guest_write_action","guest_remove_action","guest_modify_action"})
	public String guest_get(){
		String forwardPath="redirect:guest_main";
		return forwardPath;
	}
	
	
	/*
	@GetMapping("/guest_modify_get")
	public String guest_modify_get(HttpServletRequest request) throws Exception {
		int guest_no = Integer.parseInt((String) request.getAttribute("guest_no"));
		Guest guest = guestDao.selectByNo(guest_no);
		request.setAttribute("guest", guest);
		String forwardPath = "guest_modify_form";
		return forwardPath;
	}
	@GetMapping("/guest_write_action_get")
	public String guest_write_action_get(Model model) {
		String forwardPath = "";
		return forwardPath;
	}
	@GetMapping("/guest_remove_action_get")
	public String guest_remove_action_get(HttpServletRequest request) throws Exception {
		int no = (int)request.getAttribute("guest_no");
		guestDao.deleteGuest(no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}
	@GetMapping("/guest_modify_action_get")
	public String guest_modify_action_get(@ModelAttribute Guest guest) throws Exception {
		guestDao.updateGuest(guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}
	*/
}
