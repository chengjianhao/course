package com.zafu.engineersystem.service;

import com.zafu.engineersystem.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    int addUser(User user);

    int deleteUser(String username);

    int deleteUserById(int id);

    int updateUser(User user);

    User getUserById(int id);

    User getUserByName(String username);

    int getUserCountByName(String username);
}
