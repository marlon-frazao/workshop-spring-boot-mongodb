package com.marlonfrazao.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.marlonfrazao.workshopmongo.util.Convertible;

@Service
public interface GenericService<T extends Convertible<DTO>, DTO, ID> {

	MongoRepository<T, ID> getRepository();
	
	default List<DTO> findAll() {
		return getRepository().findAll().stream().map(x -> x.convert()).collect(Collectors.toList());
	}
}
