package com.onpe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final String ROLE_USER = "ROLE_USER";
	
	@GetMapping
	public String login(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout){
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck(Model model, HttpServletRequest request) {
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername());
		
		if (request.isUserInRole(ROLE_USER)) {
			return "main";
		}
		
		return "error";
		
	}
	
	
	
}
