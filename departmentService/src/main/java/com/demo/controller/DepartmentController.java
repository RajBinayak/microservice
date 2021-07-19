package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Department;
import com.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.create(department);
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id) {
		System.out.println("lllllll");
		return departmentService.getDepartment(id);
	}

}
