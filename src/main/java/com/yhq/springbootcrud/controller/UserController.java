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
    public String getById(@PathVariable("id") String id) {
        String ret = "";
        try{
            int idValue = Integer.parseInt(id);
            if (idValue <= 0){
                ret = "输入有误！";
            } else {
                ret = userManager.getById(Integer.parseInt(id));
            }
        } catch (Exception e) {
            ret = "输入有误！";
        }
        return ret;
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
