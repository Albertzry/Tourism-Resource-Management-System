package com.project.mapper;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询全部
    @Select("select * from login")
    List<User> selectAllUser();
    //查询用户根据用户名
    @Select("select * from login where username=#{username} ")
    User selectUserByname(String username);
    //更新密码
    @Update("update login set password=#{password} where username=#{username} ")
    void updateUser(User user);
    //注册
    @Insert("insert into login(username,password) values(#{username},#{password})")
    void insertUser(User user);
    //mine
    @Select("select * from login where username=#{username}")
    List<User> selectUserByName1(String username);
}
