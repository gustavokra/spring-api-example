package com.kraemer.primeira_api_spring.controller;

import com.kraemer.primeira_api_spring.model.User;
import com.kraemer.primeira_api_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User User) {
        return service.createUser(User);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User User, @PathVariable("id") Integer id) {
        return service.updateUser(User, id);
    }
}
