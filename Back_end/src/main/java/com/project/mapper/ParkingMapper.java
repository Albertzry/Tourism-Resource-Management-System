package com.project.mapper;

import com.project.pojo.Parking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkingMapper {
    //查询全部
    @Select("SELECT * FROM parking")
    List<Parking> getAllParking();
    //根据停车时间降序排序
    @Select("SELECT * FROM parking order by parking_time desc")
    List<Parking> getAllParkingByParkingTime();
    //根据车牌号查询
    @Select("SELECT * FROM parking WHERE car_num = #{car_num}")
    List<Parking> getParkingByCarNum(String car_num);
    //新增信息，初始化入库信息
    @Insert("Insert into parking(id, car_num, parking_time, leave_time) values(#{id}, #{car_num}, (select NOW()), #{leave_time})")
    boolean insertParking(Parking parking);
    //删除信息
    @Delete("DELETE FROM parking WHERE car_num = #{car_num}")
    boolean deleteParking(String car_num);
    //更新信息，初始化出库信息
    @Update("UPDATE parking SET leave_time = (select NOW()) WHERE car_num = #{car_num}")
    boolean updateParking(String car_num);
}
