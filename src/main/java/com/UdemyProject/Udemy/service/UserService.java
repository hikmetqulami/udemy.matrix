package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.response.RegisterResponse;
import com.UdemyProject.Udemy.entity.User;

public interface UserService {


    UserPageResponse getAll(int page, int count);

    UserDto findById(Long id);

    UserDto add(UserDto userDto);

    User update(User user);

    void delete(Long id);

  User getUserByEmail(String email);

  void register(RegisterRequest request);
//
//    RegisterResponse register(RegisterRequest request);
//
//    void verify(String email,String otp);

}
