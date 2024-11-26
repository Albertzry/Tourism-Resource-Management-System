package com.project.controller;
import com.project.pojo.Parking;
import com.project.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//parking表对应接口
@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "*")
public class ParkingController {

    @Autowired
    ParkingService parkingService;
    //查全部
    @GetMapping(value = "/info", produces = "application/json;charset=utf-8")
    public List<Parking> getAllParking() {
        return parkingService.getAllParking();
    }
    //按停车时间排序
    @GetMapping(value = "/info/sortTime", produces = "application/json;charset=utf-8")
    public List<Parking> getAllParkingSortByTime() {
        return parkingService.getAllParkingByParkingTime();
    }
    //根据车牌号查
    @GetMapping(value = "/search/{car_num}", produces = "application/json;charset=utf-8")
    public List<Parking> getParkingByCarNum(@PathVariable("car_num") String car_num) {
        return parkingService.getParkingByNum(car_num);
    }
    //修改接口（出库）
    @PostMapping(value = "/leave/{car_num}", produces = "application/json;charset=utf-8")
    public boolean leaveParking(@PathVariable("car_num") String car_num) {
        return parkingService.updateParking(car_num);
    }
    //删除接口
    @PostMapping(value = "/delete/{car_num}", produces = "application/json;charset=utf-8")
    public boolean deleteParking(@PathVariable("car_num") String car_num) {
        return parkingService.deleteParking(car_num);
    }
    //添加接口
    @PostMapping(value = "/add", produces = "application/json;charset=utf-8")
    public boolean addParking(@RequestBody Parking parking) {
        return parkingService.addParking(parking);
    }
}
