package com.dl.blog_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.dl.blog_app.payload.ApiResponse;
import com.dl.blog_app.payload.CommentDto;
import com.dl.blog_app.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create a new comment for a specific post
 
  @PostMapping("/posts/{postId}/comments")  
public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable int postId){

	CommentDto createComment = this.commentService.createComment(comment,postId);
	return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
}
  @DeleteMapping("/comments/{commentId}")
 public ResponseEntity<ApiResponse>deleteComment(@PathVariable int commentId){
	 this.commentService.deleteComment(commentId);
	 return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully", true),HttpStatus.OK);
  }

}