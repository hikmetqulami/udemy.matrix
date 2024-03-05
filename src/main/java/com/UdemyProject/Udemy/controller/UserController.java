package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.repository.UserRepository;
import com.UdemyProject.Udemy.service.serviceImp.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    private final UserRepository userRepository;


    @GetMapping
    public UserPageResponse getAll(@RequestParam(value = "page") int page,
                                   @RequestParam(value = "count") int count) {
        return userServiceImpl.getAll(page, count);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new ResponseEntity<>("User is taken", HttpStatus.BAD_REQUEST);
        }
        userServiceImpl.register(request);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);

    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid RegisterRequest request) {
        return userServiceImpl.login(request);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @PutMapping
    public User update(@RequestBody UserDto userDto) {
        return userServiceImpl.update(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userServiceImpl.delete(id);
    }

}

