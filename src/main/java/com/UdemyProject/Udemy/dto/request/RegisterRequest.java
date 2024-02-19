package com.UdemyProject.Udemy.dto.request;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegisterRequest{
        private String username;
        private String email;
        private String password;

}
