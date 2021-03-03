package com.marlonfrazao.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.dto.PostDTO;
import com.marlonfrazao.workshopmongo.resources.util.URL;
import com.marlonfrazao.workshopmongo.services.GenericService;
import com.marlonfrazao.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource implements GenericResource<Post, PostDTO, String> {

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

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		return ResponseEntity.ok().body(service.findByTitle(URL.decodeParam(text)));
	}

	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullsearch(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
		return ResponseEntity.ok().body(service.fullSearch(URL.decodeParam(text),
				URL.convertDate(minDate, new Date(0L)), URL.convertDate(maxDate, new Date())));
	}

}
