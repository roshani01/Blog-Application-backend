package com.dl.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.blog_app.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
