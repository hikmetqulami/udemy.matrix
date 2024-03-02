package com.UdemyProject.Udemy.service.serviceImp;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.dto.UserPageResponse;
import com.UdemyProject.Udemy.dto.request.RegisterRequest;
import com.UdemyProject.Udemy.entity.Role;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.exception.NotFoundException;
import com.UdemyProject.Udemy.mapper.UserMapper;
import com.UdemyProject.Udemy.repository.RoleRepository;
import com.UdemyProject.Udemy.repository.UserRepository;
import com.UdemyProject.Udemy.security.jwt.JWTGenerator;
import com.UdemyProject.Udemy.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTGenerator jwtGenerator;

    private final RoleRepository roleRepository;


    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .stream()
                .map(userMapper::toUserDto)
                .findFirst().orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public UserPageResponse getAll(int page, int count) {

        Page<User> userPage = userRepository.findAll(PageRequest.of(page, count));

        return new UserPageResponse(
                userPage.getContent().stream().map(userMapper::toUserDto).toList(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.hasNext()
        );
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User update(User user) {
        log.info("User update successfully");
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        log.info("User with " + id + "is deleted");
    }

    @Override
    public void register(RegisterRequest request) {

        User user = userMapper.toUserFromRegisterRequest(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role roles = roleRepository.findByName("USER").orElseThrow(() ->
                new RuntimeException("Default role not found"));
        user.setRoleList(Collections.singletonList(roles));
        userRepository.save(user);
    }

    @Override
    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        UserDetails user = userMapper.toCustomUserDetails(getUserByEmail(request.getEmail()));
        return jwtGenerator.generateToken(user);
    }
}