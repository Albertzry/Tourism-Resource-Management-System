package com.project.service;

import com.project.pojo.Hotel;

import java.util.List;

public interface HotelService {
    //查全部
    List<Hotel> getAllHotels();
    //按容量排序
    List<Hotel> getHotelByCapacity();
    //按星级排序
    List<Hotel> getHotelByLevel();
    //根据id查
    List<Hotel> getHotelById(int id);
    //添加
    boolean addHotel(Hotel hotel);
    //删除
    boolean deleteHotel(int id);
    //修改
    boolean updateHotel(Hotel hotel);
}
