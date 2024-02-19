package com.UdemyProject.Udemy.security.details;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.entity.Role;
import com.UdemyProject.Udemy.entity.User;
import com.UdemyProject.Udemy.mapper.UserMapper;
import com.UdemyProject.Udemy.repository.UserRepository;
import com.UdemyProject.Udemy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toCustomUserDetails(userService.getUserByEmail(username));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
