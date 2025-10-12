package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	private String users(Model model) {
		List<User> users = userService.findAllUsers();
		
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		
		return "users";
	}
	
	@PostMapping("/user")
	private String addUser(UserForm userForm) {
		userService.createUser(userForm.getName(), userForm.getEmail());
		
		return "redirect:/users";
	}
}
