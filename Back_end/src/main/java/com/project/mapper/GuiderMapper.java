package com.project.mapper;

import com.project.pojo.Guider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuiderMapper {
    //查全部(按id升序排序）
    @Select("select * from guiders")
    List<Guider> selectAllGuiders();
    //查全部（按age降序排序）
    @Select("select * from guiders order by age desc")
    List<Guider> selectAllGuidersByAge();
    //查全部（按work_exp降序排序）
    @Select("select * from guiders order by work_exp desc")
    List<Guider> selectAllGuidersByWorkExp();
    //查id
    @Select("select * from guiders where id=#{id}")
    List<Guider> selectGuiderById(int id);
    //查名字
    @Select("select * from guiders where name=#{name}")
    List<Guider> selectGuiderByName(String name);
    //查电话
    @Select("select * from guiders where phone=#{phone}")
    List<Guider> selectGuiderByPhone(String phone);
    //新增
    @Insert("insert into guiders (id,name,age,sex,phone,work_exp) values(#{id},#{name},#{age},#{sex},#{phone},#{work_exp})")
    void insertGuider(Guider guider);
    //修改
    @Update("update guiders set name=#{name},age=#{age},sex=#{sex},phone=#{phone},work_exp=#{work_exp} where id=#{id}")
    void updateGuider(Guider guider);
    //删除
    @Delete("delete from guiders where id=#{id}")
    void deleteGuider(int id);
}
