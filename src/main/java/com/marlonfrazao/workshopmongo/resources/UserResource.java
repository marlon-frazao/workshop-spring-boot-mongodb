package com.marlonfrazao.workshopmongo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marlonfrazao.workshopmongo.domain.User;
import com.marlonfrazao.workshopmongo.dto.UserDTO;
import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements GenericResource<User, UserDTO, String> {

	@Autowired
	private UserService service;

	@Override
	public GenericService<User, UserDTO, String> getService() {
		return service;
	}

	@Override
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(getService().insert(objDto.convert()).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Override
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = objDto.convert();
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
