package com.project.service;

import com.project.pojo.User;

import java.util.List;

public interface UserService {
    //展示全部
    List<User> findUser();
    //根据name找User
    User findUserByName(String username);
    //修改User
    void updateUser(User user);
    //注册
    void insertUser(User user);
    //mine的展示
    List<User> showUser(String username);
}
