package com.project.service;

import com.project.mapper.UserMapper;
import com.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper usermapper;
    //查全部实现
    @Override
    public List<User> findUser() {
        return usermapper.selectAllUser();
    }
    //根据名字查实现
    @Override
    public User findUserByName(String username) {
        return usermapper.selectUserByname(username);
    }
    //修改实现
    @Override
    public void updateUser(User user) {
       usermapper.updateUser(user);
    }
    //注册
    @Override
    public void insertUser(User user) {
        usermapper.insertUser(user);
    }

    @Override
    public List<User> showUser(String username) {
        return usermapper.selectUserByName1(username);
    }
}
