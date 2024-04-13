package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.model.User;
import com.springsecurity.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.get();
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).get();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        User save = userRepository.save(user1);
        return save;
    }

    @Override
    public String deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "student is delete succefully !!!";
        }
        return "Student is not available in the database";
    }

}
