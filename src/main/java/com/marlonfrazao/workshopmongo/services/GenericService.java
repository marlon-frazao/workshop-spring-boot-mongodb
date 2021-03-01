package com.marlonfrazao.workshopmongo.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<T, ID> {

	MongoRepository<T, ID> getRepository();
	
	default List<T> findAll() {
		return getRepository().findAll();
	}
}
