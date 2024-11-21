package com.dl.blog_app.services;

import com.dl.blog_app.payload.PostDto;
import com.dl.blog_app.payload.PostResponse;

import java.util.List;

public interface PostService {

    // Create a new post
    PostDto createPost(PostDto postDto, int userId, int categoryId);

    // Update an existing post
    PostDto updatePost(int postId, PostDto postDto);

    // Delete a post by ID
    void deletePost(int postId);

    // Retrieve a post by ID
    PostDto getPostById(int postId);

    // Retrieve all posts with pagination and sorting
    PostResponse getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir);

    // Retrieve all posts by category
    List<PostDto> getPostByCategory(int categoryId);

    // Retrieve all posts by user
    List<PostDto> getPostByUser(int userId);

    // Search posts by keyword
    List<PostDto> searchPosts(String keyword);
}
