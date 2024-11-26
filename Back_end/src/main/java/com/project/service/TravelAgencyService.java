package com.project.service;

import com.project.pojo.TravelAgency;

import java.util.List;

public interface TravelAgencyService {
    //查全部
    List<TravelAgency> selectAll();
    //根据id查
    List<TravelAgency> selectById(int id);
    //添加
    void insert(TravelAgency travelAgency);
    //修改
    void update(TravelAgency travelAgency);
    //删除
    void delete(int id);
}
