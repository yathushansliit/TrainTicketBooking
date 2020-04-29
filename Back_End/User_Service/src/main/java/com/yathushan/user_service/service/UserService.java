package com.yathushan.user_service.service;

import com.yathushan.user_service.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User findUser(int id);

    List<User> fetchAllUsers();
}
