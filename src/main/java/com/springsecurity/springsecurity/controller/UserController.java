package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.model.User;
import com.springsecurity.springsecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
public class UserController {
    @Autowired
    public UserServiceImpl userServiceImpl;
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userServiceImpl.createUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userServiceImpl.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }


    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User userById = userServiceImpl.getUserById(id);
        return new ResponseEntity<>(userById,HttpStatus.FOUND);
    }


}
