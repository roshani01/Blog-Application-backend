package com.dl.blog_app.services;

import java.util.List;

import com.dl.blog_app.payload.UserDto;

public interface UserServices {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getIdByUser(Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer userId);
}
