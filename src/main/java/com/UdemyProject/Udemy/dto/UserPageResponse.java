package com.UdemyProject.Udemy.dto;

import com.UdemyProject.Udemy.dto.UserDto;

import java.util.List;

public record UserPageResponse(
    List<UserDto> users,
    long totalElements,
    int totalPage,
    boolean hasNextPage

) {
}
