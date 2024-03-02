package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.dto.AuthResponseDTO;
import com.UdemyProject.Udemy.dto.request.LoginRequest;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.Role;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.repository.RoleRepository;
import com.UdemyProject.Udemy.repository.UserRepository;
import com.UdemyProject.Udemy.security.jwt.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager manager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTGenerator jwtGenerator;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {


        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getEmail()));

//        Role roles = roleRepository.findByName("USER").orElseThrow(() ->
//                new RuntimeException("Default role not found"));
//        user.setRoleList(Collections.singletonList(roles));

        userRepository.save(user);


        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }


}