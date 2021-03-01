package com.marlonfrazao.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.marlonfrazao.workshopmongo.domain.User;
import com.marlonfrazao.workshopmongo.dto.UserDTO;
import com.marlonfrazao.workshopmongo.repository.UserRepository;

@Service
public class UserService implements GenericService<User, UserDTO, String>{

	@Autowired
	private UserRepository repository;
	
	@Override
	public MongoRepository<User, String> getRepository() {
		return repository;
	}

	
}
