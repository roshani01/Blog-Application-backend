package com.dl.blog_app.services;

import com.dl.blog_app.payload.CommentDto;

public interface  CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);
 
	

}
