package com.marlonfrazao.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.util.Convertible;

@RestController
public interface GenericResource<T extends Convertible<DTO>, DTO extends Convertible<T>, ID> {

	GenericService<T, DTO, ID> getService();
	
	@GetMapping
	default ResponseEntity<List<DTO>> findAll() {
		return ResponseEntity.ok().body(getService().findAll());
	}
	
	@GetMapping(value = "/{id}")
	default ResponseEntity<DTO> findById(@PathVariable ID id) {
		return ResponseEntity.ok().body(getService().findById(id));
	}
	
	
	ResponseEntity<Void> insert(DTO objDto);
		
	
}
