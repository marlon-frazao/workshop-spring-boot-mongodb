package com.marlonfrazao.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.dto.PostDTO;
import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource implements GenericResource<Post, PostDTO, String>{

	@Autowired
	private PostService service;
	
	@Override
	public GenericService<Post, PostDTO, String> getService() {
		return service;
	}

	@Override
	public ResponseEntity<Void> insert(PostDTO objDto) {
		return null;
	}

	@Override
	public ResponseEntity<Void> update(PostDTO objDto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
