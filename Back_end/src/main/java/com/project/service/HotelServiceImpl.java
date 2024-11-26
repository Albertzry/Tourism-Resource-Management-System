package com.project.service;

import com.project.mapper.HotelMapper;
import com.project.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelMapper hotelMapper;
    //查全部
    @Override
    public List<Hotel> getAllHotels() {
        return hotelMapper.getHotelList();
    }
    //按id查
    @Override
    public List<Hotel> getHotelById(int id) {
        return hotelMapper.getHotelById(id);
    }
    //添加
    @Override
    public boolean addHotel(Hotel hotel) {
        return hotelMapper.insertHotel(hotel);
    }
    //删除
    @Override
    public boolean deleteHotel(int id) {
        return hotelMapper.deleteHotel(id);
    }
    //修改
    @Override
    public boolean updateHotel(Hotel hotel) {
        return hotelMapper.updateHotel(hotel);
    }
    //按容量排序
    @Override
    public List<Hotel> getHotelByCapacity() {
        return hotelMapper.getHotelListByCapacity();
    }
    //按星级排序
    @Override
    public List<Hotel> getHotelByLevel() {
        return hotelMapper.getHotelListByLevel();
    }

}
