package com.yathushan.user_service.controller;

import com.yathushan.user_service.model.User;
import com.yathushan.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "findUser/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findUser(id);
    }

    @RequestMapping(value = "/fetchAllUsers", method = RequestMethod.GET)
    public List<User> fetchAllUsers(){
        return userService.fetchAllUsers();
    }
}
