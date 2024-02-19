package com.UdemyProject.Udemy.dto.manager;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDtoManager implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getAge());
    }
}
