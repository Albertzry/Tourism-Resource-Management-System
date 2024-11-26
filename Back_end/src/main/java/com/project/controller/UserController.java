package com.project.controller;

import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//login表对应接口
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    //查全部接口（用于个人中心数据渲染）
    @GetMapping(value="/mine/user/info",produces = "application/json")
    public List<User> findUser(){
        return userService.findUser();
    }
    //根据name查（用于Login登陆页面核对）
    @GetMapping(value="/login/user/{username}",produces = "application/json")
    public User findUserByName(@PathVariable("username") String username){
        return userService.findUserByName(username);
    }
    //修改接口（用于个人中心数据修改）
    @PostMapping(value = "/mine/user/update",produces = "application/json")
    public void updateUser(@RequestBody User user){
        userService. updateUser(user);
    }
    //注册（用于注册页面）
    @PostMapping(value = "/login/insert",produces = "application/json")
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
    //mine
     @GetMapping(value = "/mine/user/info/searchByName/{username}",produces = "application/json")
     public List<User> showUser(@PathVariable("username") String username){
        return userService.showUser(username);
     }
}
