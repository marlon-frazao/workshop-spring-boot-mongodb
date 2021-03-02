package com.marlonfrazao.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.marlonfrazao.workshopmongo.services.exception.ObjectNotFoundException;
import com.marlonfrazao.workshopmongo.util.Convertible;

@Service
public interface GenericService<T extends Convertible<DTO>, DTO extends Convertible<T>, ID> {

	MongoRepository<T, ID> getRepository();
	
	default List<DTO> findAll() {
		return getRepository().findAll().stream().map(x -> x.convert()).collect(Collectors.toList());
	}
	
	default DTO findById(ID id) {
		Optional<T> obj = getRepository().findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")).convert();
	}
	
	default DTO insert(T obj) {
		return getRepository().insert(obj).convert();
	}
	
	default void delete(ID id) {
		findById(id);
		getRepository().deleteById(id);
	}
}
