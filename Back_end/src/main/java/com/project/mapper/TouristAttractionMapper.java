package com.project.mapper;

import com.project.pojo.TouristAttraction;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TouristAttractionMapper {
    //查全部
    @Select("SELECT * FROM tourist_attraction")
    List<TouristAttraction> selectAll();
    //删除
    @Delete("DELETE FROM tourist_attraction where id = #{id}")
    void delete(int id);
    //添加
    @Insert("INSERT INTO tourist_attraction(id, name, address, maxParking, maxPeople, manager, managerPhone) VALUES(#{id}, #{name}, #{address}, #{maxParking}, #{maxPeople}, #{manager}, #{managerPhone})")
    void insert(TouristAttraction tourist_attraction);
    //修改
    @Update("UPDATE tourist_attraction SET name = #{name}, address = #{address}, maxParking = #{maxParking}, maxPeople = #{maxPeople}, manager = #{manager}, managerPhone = #{managerPhone} WHERE id = #{id}")
    void update(TouristAttraction tourist_attraction);
    //根据id查
    @Select("SELECT * FROM tourist_attraction where id = #{id}")
    List<TouristAttraction> selectById(int id);
}