package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.model.User;
import com.springsecurity.springsecurity.service.UserService;
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
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")

    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }


    @GetMapping("/user/{id}")

    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById,HttpStatus.FOUND);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User student, @PathVariable long id){
        User user = userService.updateUser(student);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        String s = userService.deleteUserById(id);
        return  new ResponseEntity<>(s, HttpStatus.OK);
    }
}
