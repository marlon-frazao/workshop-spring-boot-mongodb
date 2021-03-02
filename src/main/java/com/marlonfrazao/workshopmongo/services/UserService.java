package com.marlonfrazao.workshopmongo.services;

import java.util.stream.Collectors;

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

	@Override
	public User update(User obj) {
		User newObj = repository.findAll().stream().filter(x -> x.getId().equals(obj.getId())).collect(Collectors.toList()).get(0);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	@Override
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
