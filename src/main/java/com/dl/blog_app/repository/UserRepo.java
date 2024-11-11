package com.dl.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.blog_app.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
