package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.vo.ResponseTemplateVo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVo getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	
}
