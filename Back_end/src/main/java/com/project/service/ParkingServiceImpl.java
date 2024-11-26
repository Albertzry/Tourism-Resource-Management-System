package com.project.service;

import com.project.mapper.ParkingMapper;
import com.project.pojo.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService{

    @Autowired
    ParkingMapper parkingMapper;
    //查全部
    @Override
    public List<Parking> getAllParking() {
        return parkingMapper.getAllParking();
    }
    //按停车时间降序排序
    @Override
    public List<Parking> getAllParkingByParkingTime() {
        return parkingMapper.getAllParkingByParkingTime();
    }
    //根据车牌号查
    @Override
    public List<Parking> getParkingByNum(String car_num) {
        return parkingMapper.getParkingByCarNum(car_num);
    }
    //添加
    @Override
    public boolean addParking(Parking parking) {
        return parkingMapper.insertParking(parking);
    }
    //删除
    @Override
    public boolean deleteParking(String car_num) {
        return parkingMapper.deleteParking(car_num);
    }
    //修改
    @Override
    public boolean updateParking(String car_num) {
        return parkingMapper.updateParking(car_num);
    }


}