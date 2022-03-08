package com.todo.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.model.User;
import com.todo.demo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public Map<String, Object> registerUser(@RequestBody User user) throws Exception {
		return userService.login(user.getEmail(), user.getPassword());
	}

	@PostMapping("/register")
	public User loginUser(@RequestBody User user) {
		return userService.register(user);
	}
}
