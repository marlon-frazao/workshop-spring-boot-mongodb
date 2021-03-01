package com.marlonfrazao.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlonfrazao.workshopmongo.domain.User;
import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements GenericResource<User, String>{
	
	@Autowired
	private UserService service;
	
	@Override
	public GenericService<User, String> getService() {
		return service;
	}
	
}
