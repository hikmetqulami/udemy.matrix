package com.UdemyProject.Udemy.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest{


        private String username;

        @Email
        private String email;

        @Size(min = 8)
        private String password;

}
