package com.marlonfrazao.workshopmongo.dto;

import java.util.Date;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.util.Convertible;

public class PostDTO implements Convertible<Post>{

	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {}
	
	public PostDTO(Post entity) {
		id = entity.getId();
		date = entity.getDate();
		title = entity.getTitle();
		body = entity.getBody();
		author = entity.getAuthor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	@Override
	public Post convert() {
		return new Post(this);
	}
}
