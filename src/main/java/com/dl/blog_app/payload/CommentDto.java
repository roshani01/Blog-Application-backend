package com.dl.blog_app.payload;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class CommentDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CommentDto(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	



}
