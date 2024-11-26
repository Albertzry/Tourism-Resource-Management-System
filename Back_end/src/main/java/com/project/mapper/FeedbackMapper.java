package com.project.mapper;

import com.project.pojo.Feedback;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    //查询全部
    @Select("select * from feedback")
    List<Feedback> getFeedback();
    //按分数降序排序
    @Select("select * from feedback order by score desc")
    List<Feedback> getFeedbackByScore();
    //根据name查询
    @Select("select * from feedback where name = #{name}")
    List<Feedback> getFeedbackByName(String name);
    //根据phone查询
    @Select("select * from feedback where phone = #{phone}")
    List<Feedback> getFeedbackByPhone(String phone);
    //添加
    @Insert("insert into feedback(id, name, phone, content, score, date) values(#{id}, #{name}, #{phone}, #{content}, #{score}, (select curdate()))")
    boolean addFeedback(Feedback feedback);
    //修改
    @Update("update feedback set score = #{score}, phone = #{phone}, content = #{content}, name = #{name} where id = #{id}")
    boolean updateFeedback(Feedback feedback);
    //删除
    @Delete("delete from feedback where id = #{id}")
    boolean deleteFeedback(int id);
}
