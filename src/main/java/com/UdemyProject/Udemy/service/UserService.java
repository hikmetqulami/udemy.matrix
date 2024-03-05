package com.UdemyProject.Udemy.service;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.Course;
import com.UdemyProject.Udemy.entity.User;

import java.util.List;

public interface UserService {


    UserPageResponse getAll(int page, int count);

    UserDto findById(Long id);

    User update(UserDto userDto);

    void delete(Long id);

    User getUserByEmail(String email);

    void register(RegisterRequest request);

    String login(RegisterRequest request);



}
