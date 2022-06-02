package com.springboot.officesystem.controller;
import com.springboot.officesystem.model.User;
import com.springboot.officesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(){
        User user = new User();
        user.setPassword("admin");
        user.setUsername("admin");
        return userService.addUser(user);
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        Boolean result = userService.deleteUser(id);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
        return user;
    }

    @PutMapping("/put")
    public User updateUser(@RequestBody User user){
        User newUser = userService.updateUser(user);
        if (newUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user id is not found");
        }
        return newUser;
    }

    @GetMapping("/getAccounts/{type}")
    public List<User> getAccounts(@PathVariable("type") int type){
        if (type == 1) {
            return userService.getAccount(true);
        } else if (type == 0) {
            return userService.getAccount(false);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "type is not valid");
        }
    }

    @PostMapping("/login/{id}")
    public User login(@PathVariable("id") Long id){
        User user = userService.login(id);
        if (user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID is not found");
        }
    }

    @PostMapping("/logout/{id}")
    public User logout(@PathVariable("id") Long id){
        User user = userService.logout(id);
        if (user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID is not found");
        }
    }


}
