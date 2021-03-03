package com.marlonfrazao.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.dto.PostDTO;
import com.marlonfrazao.workshopmongo.repository.PostRepository;

@Service
public class PostService implements GenericService<Post, PostDTO, String>{

	@Autowired
	private PostRepository repository;
	
	@Override
	public MongoRepository<Post, String> getRepository() {
		return repository;
	}

	@Override
	public Post update(Post obj) {
		return null;
	}

	@Override
	public void updateData(Post newObj, Post obj) {		
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
