package com.UdemyProject.Udemy.mapper;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.security.details.CustomUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toEntity(UserDto userDto);

    CustomUserDetails toCustomUserDetails(User user);

    User toUserFromRegisterRequest(RegisterRequest request);

}
