package com.project.mapper;

import com.project.pojo.TravelAgency;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TravelAgencyMapper {
    //查全部
    @Select("select * from travel_agency")
    List<TravelAgency> selectAll();
    //根据id查
    @Select("select * from travel_agency where id=#{id}")
    List<TravelAgency> selectById(int id);
    //添加
    @Insert("insert into travel_agency(id,name,phone,email,address,createTime) values(#{id},#{name},#{phone},#{email},#{address},#{createTime})")
    void insert(TravelAgency travelAgency);
    //修改
    @Update("update travel_agency set name=#{name},phone=#{phone},email=#{email},address=#{address} createTime=#{createTime} where id=#{id}")
    void update(TravelAgency travelAgency);
    //删除
    @Delete("delete from travel_agency where id=#{id}")
    void delete(int id);
}
