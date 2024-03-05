package com.UdemyProject.Udemy.repository;

import com.UdemyProject.Udemy.dto.UserDto;
import com.UdemyProject.Udemy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);


  Boolean existsByEmail(String email);

}
