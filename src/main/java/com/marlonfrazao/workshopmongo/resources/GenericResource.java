package com.marlonfrazao.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.util.Convertible;

@RestController
public interface GenericResource<T extends Convertible<DTO>, DTO, ID> {

	GenericService<T, DTO, ID> getService();
	
	@GetMapping
	default ResponseEntity<List<DTO>> findAll() {
		return ResponseEntity.ok().body(getService().findAll());
	}
}