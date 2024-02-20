package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.service.serviceImp.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImpl userServiceImpl;

    private final PasswordEncoder passwordEncoder;


    @GetMapping
    public UserPageResponse getAll(@RequestParam(value = "page") int page,
                                   @RequestParam(value = "count") int count) {
        return userServiceImpl.getAll(page, count);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto user) {
        userServiceImpl.add(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userServiceImpl.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userServiceImpl.delete(id);
    }


    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        userServiceImpl.register(request);
    }
}

