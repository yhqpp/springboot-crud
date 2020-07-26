package com.yhq.springbootcrud.controller;

import com.yhq.springbootcrud.domain.User;
import com.yhq.springbootcrud.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserManager userManager;

    @PostMapping("/add")
    public void insert(@RequestParam("id") Integer id, @RequestParam("username") String username, @RequestParam("password") String password) {
        User newUser = new User(id,username,password);
        userManager.insert(newUser);
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") Integer id) {
        return userManager.getById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestParam("username") String username,@RequestParam("password") String password) {
        userManager.updateById(new User(id, username, password));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userManager.deleteById(id);
    }

    @RequestMapping("/get")
    public String getAllUsers() {
        return userManager.getAllUsers();
    }


}
