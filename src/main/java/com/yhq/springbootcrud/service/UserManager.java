package com.yhq.springbootcrud.service;

import com.yhq.springbootcrud.dao.UserDao;
import com.yhq.springbootcrud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager {

    @Autowired
    private UserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public String getById(int id) {
        List<User> users = userDao.selectById(id);
        if(users.size()==0)
            return "您要找的用户不存在！";
        else
            return users.get(0).toString();
    }

    public void updateById(User user) {
        userDao.updateById(user);
    }

    public void deleteById(int id) {
        userDao.deleteByID(id);
    }

    public String getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        String ret = "";
        for(User user : allUsers) {
            ret += user;
            ret+="\n";
        }
        return ret;
    }
}
