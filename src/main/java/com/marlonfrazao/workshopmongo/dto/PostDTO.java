package com.marlonfrazao.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marlonfrazao.workshopmongo.domain.Post;
import com.marlonfrazao.workshopmongo.util.Convertible;

public class PostDTO implements Convertible<Post>, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	
	private AuthorDTO author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public PostDTO() {}
	
	public PostDTO(Post entity) {
		id = entity.getId();
		date = entity.getDate();
		title = entity.getTitle();
		body = entity.getBody();
		author = entity.getAuthor();
		comments.addAll(entity.getComments());
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
	
	public List<CommentDTO> getComments() {
		return comments;
	}

	@Override
	public Post convert() {
		return new Post(this);
	}
}
