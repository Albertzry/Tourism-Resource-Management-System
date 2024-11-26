package com.project.service;

import com.project.pojo.Parking;

import java.util.List;

public interface ParkingService {
    //查全部
    List<Parking> getAllParking();
    //按停车时间排序
    List<Parking> getAllParkingByParkingTime();
    //根据车牌号查
    List<Parking> getParkingByNum(String car_num);
    //添加
    boolean addParking(Parking parking);
    //删除
    boolean deleteParking(String car_num);
    //修改
    boolean updateParking(String car_num);
}

