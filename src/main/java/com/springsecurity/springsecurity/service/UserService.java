package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.model.User;

import java.util.List;

public interface UserService {
    // for User Create
    public User createUser(User user);

    // get All Users

    public List<User> getAllUsers();

    //get User By Id
    public User getUserById(Long id);
}
