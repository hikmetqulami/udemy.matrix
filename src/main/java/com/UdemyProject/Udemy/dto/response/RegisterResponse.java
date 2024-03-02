package com.UdemyProject.Udemy.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String username;
    private String email;
}
