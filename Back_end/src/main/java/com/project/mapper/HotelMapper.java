package com.project.mapper;

import com.project.pojo.Hotel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HotelMapper {
    //查询全部
    @Select("SELECT * FROM hotel")
    List<Hotel> getHotelList();
    //按容量降序排序
    @Select("SELECT * FROM hotel order by capacity desc")
    List<Hotel> getHotelListByCapacity();
    //按星级降序排序
    @Select("SELECT * FROM hotel order by level desc")
    List<Hotel> getHotelListByLevel();
    //根据id查询
    @Select("SELECT * FROM hotel WHERE id=#{id}")
    List<Hotel> getHotelById(int id);
    //添加
    @Insert("INSERT INTO hotel (id, name, level, phone, capacity, email) VALUES (#{id}, #{name}, #{level}, #{phone}, #{capacity}, #{email})")
    boolean insertHotel(Hotel hotel);
    //修改
    @Update("UPDATE hotel SET name=#{name}, level=#{level}, phone=#{phone}, capacity=#{capacity}, email=#{email} WHERE id=#{id}")
    boolean updateHotel(Hotel hotel);
    //删除
    @Delete("DELETE FROM hotel WHERE id=#{id}")
    boolean deleteHotel(int id);
}
