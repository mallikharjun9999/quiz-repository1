package com.conceptile.quize.services;
import com.conceptile.quize.entities.UserEntity;
import com.conceptile.quize.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser.isPresent()) {
            throw new IllegalStateException("Username already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public UserEntity findUser(UserEntity user) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(user.getUsername());
        return userOptional.orElse(null);
    }

    @Override
    public UserEntity addUser1(UserEntity user) {
        return userRepository.save(user);
    }
}
