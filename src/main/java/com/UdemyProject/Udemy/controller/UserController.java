package com.UdemyProject.Udemy.controller;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.dto.response.RegisterResponse;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.service.UserService;
import com.UdemyProject.Udemy.service.serviceImp.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImpl userServiceImpl;


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
    public void register(@RequestBody RegisterRequest request) {
        userServiceImpl.register(request);
    }


    /*

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        Optional<User> existingUserOptional = userRepository.findUserByEmail(request.getEmail());
        if (userRepository.existsByUsername(request.getEmail())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode((request.getPassword())));


        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        user.setIsActive(false);

        user.setActivationCode(UUID.randomUUID().toString());

        if (!StringUtils.isEmpty(user.getEmail())) {
            String username =user.getUsername() != null ? user.getUsername():"User";

            String message = String.format(
                    "Hello," + username +  "\n" +
                            "Welcome to Udemy Demo Application. " +
                            "Please, visit next link: http://localhost:8080/activate/" + user.getActivationCode(),
                    user.getUsername()


            );
            mailService.send(user.getEmail(), "Activation code", message);
        }
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

     */
}

