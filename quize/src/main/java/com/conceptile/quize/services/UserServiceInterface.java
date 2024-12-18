package com.conceptile.quize.services;

import com.conceptile.quize.entities.UserEntity;

public interface UserServiceInterface {
    UserEntity addUser(UserEntity user);

    UserEntity findUser(UserEntity user);

    UserEntity addUser1(UserEntity user);
}
