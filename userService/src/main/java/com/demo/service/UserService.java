package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.entity.User;
import com.demo.repository.UserRepo;
import com.demo.vo.Department;
import com.demo.vo.ResponseTemplateVo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public ResponseTemplateVo getUser(Long id) {
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		
		User user =  userRepo.findByUserId(id);
		Department department  = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(), 
						Department.class);
		responseTemplateVo.setDepartment(department);
		responseTemplateVo.setUser(user);
		return responseTemplateVo;
	}

}
