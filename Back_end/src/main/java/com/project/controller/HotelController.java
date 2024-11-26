package com.project.controller;

import com.project.pojo.Hotel;
import com.project.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//hotel表对应接口
@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    HotelService hotelService;
    //查全部
    @GetMapping(value = "/info", produces = "application/json;charset=utf-8")
    public List<Hotel> getHotelInfo() {
        return hotelService.getAllHotels();
    }
    //根据id查
    @GetMapping(value = "/search/{id}", produces = "application/json;charset=utf-8")
    public List<Hotel> getHotelInfoById(@PathVariable("id") Integer id) {
        return hotelService.getHotelById(id);
    }
    //根据容量排序
    @GetMapping(value = "/info/capacitySort", produces = "application/json;charset=utf-8")
    public List<Hotel> getHotelInfoByCapacitySort() {
        return hotelService.getHotelByCapacity();
    }
    //根据星级排序
    @GetMapping(value = "/info/levelSort",  produces = "application/json;charset=utf-8")
    public List<Hotel> getHotelInfoByLevelSort() {
        return hotelService.getHotelByLevel();
    }
    //修改
    @PostMapping(value = "/edit", produces = "application/json;charset=utf-8")
    public boolean updateHotel(@RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotel);
    }
    //删除
    @PostMapping(value = "/delete/{id}", produces = "application/json;charset=utf-8")
    public boolean deleteHotel(@PathVariable("id") Integer id) {
        return hotelService.deleteHotel(id);
    }
    //添加
    @PostMapping(value = "/add", produces = "application/json;charset=utf-8")
    public boolean addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }
}
