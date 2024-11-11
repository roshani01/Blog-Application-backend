package com.dl.blog_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dl.blog_app.entities.Category;

public interface CategoryRepo extends  JpaRepository<Category, Integer>{

}
