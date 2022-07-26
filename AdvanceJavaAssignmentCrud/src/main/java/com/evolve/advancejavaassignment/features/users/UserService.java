package com.evolve.advancejavaassignment.features.users;

import com.evolve.advancejavaassignment.data.dto.UserDto;
import com.evolve.advancejavaassignment.data.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User requestUserRegistration(UserDto userDto) {
       return repository.save(User.builder()
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .active(true)
                .build());
    }

    public Optional<User> findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
}
