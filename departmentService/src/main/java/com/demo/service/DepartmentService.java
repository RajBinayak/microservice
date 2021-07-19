package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Department;
import com.demo.repository.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	public Department create(Department department) {
		return  departmentRepo.save(department);
	}
	
	public Department getDepartment(Long id) {
		return  departmentRepo.findByDepartmentId(id);
	}

}
