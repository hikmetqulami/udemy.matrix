package com.UdemyProject.Udemy.dto;

import java.time.LocalDate;

public record UserDto(

        String username,
        String email,
        String password,
        LocalDate age
) {

}
