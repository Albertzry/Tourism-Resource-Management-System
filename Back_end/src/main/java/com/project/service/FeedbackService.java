package com.project.service;

import com.project.pojo.Feedback;

import java.util.List;

public interface FeedbackService {
    //查全部
    List<Feedback> getAllFeedbacks();
    //按分数降序排序
    List<Feedback> getAllFeedbacksByScore();
    //根据name查
    List<Feedback> getFeedbackByName(String name);
    //根据phone查
    List<Feedback> getFeedbackByPhone(String phone);
    //添加
    boolean addFeedback(Feedback feedback);
    //修改
    boolean updateFeedback(Feedback feedback);
    //删除
    boolean deleteFeedback(int id);
}
