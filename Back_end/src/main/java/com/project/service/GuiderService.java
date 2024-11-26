package com.project.service;

import com.project.pojo.Guider;

import java.util.List;

public interface GuiderService {
    //查全部
    List<Guider> listAllGuiders();
    //查全部（按age降序排序）
    List<Guider> listAllGuidersByAge();
    //查全部（按work_exp降序排序）
    List<Guider> listAllGuidersByWorkExp();
    //根据id查
    List<Guider> findGuiderById(int id);
    //根据name查
    List<Guider> findGuiderByName(String name);
    //根据phone查
    List<Guider> findGuiderByPhone(String phone);
    //新增
    void insertGuider(Guider guider);
    //修改
    void updateGuider(Guider guider);
    //删除
    void deleteGuider(int id);
}
