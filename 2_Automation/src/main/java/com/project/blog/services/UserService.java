package com.project.blog.services;

import com.project.blog.entities.User;
import com.project.blog.payload.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserByDId(Integer userId);
   List<UserDto> getAllUsers();
   void deleteUser(Integer userId);

   UserDto registerNewUser(UserDto user);

}
