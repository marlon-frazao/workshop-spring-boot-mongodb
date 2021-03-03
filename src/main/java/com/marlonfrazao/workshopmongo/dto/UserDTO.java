package com.marlonfrazao.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.domain.User;
import com.marlonfrazao.workshopmongo.util.Convertible;

public class UserDTO implements Serializable, Convertible<User>{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	private List<Post> posts = new ArrayList<>();
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		posts.addAll(obj.getPosts());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	@Override
	public User convert() {
		return new User(this);
	}
}
