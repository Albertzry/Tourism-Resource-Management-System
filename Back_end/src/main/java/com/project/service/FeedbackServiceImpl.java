package com.project.service;

import com.project.mapper.FeedbackMapper;
import com.project.pojo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    //查全部
    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackMapper.getFeedback();
    }
    //按分数降序排序
    @Override
    public List<Feedback> getAllFeedbacksByScore() {
        return feedbackMapper.getFeedbackByScore();
    }
    //根据name查
    @Override
    public List<Feedback> getFeedbackByName(String name) {
        return feedbackMapper.getFeedbackByName(name);
    }
    //根据phone查
    @Override
    public List<Feedback> getFeedbackByPhone(String phone) {
        return feedbackMapper.getFeedbackByPhone(phone);
    }
    //添加
    @Override
    public boolean addFeedback(Feedback feedback) {
        return feedbackMapper.addFeedback(feedback);
    }
    //修改
    @Override
    public boolean updateFeedback(Feedback feedback) {
        return feedbackMapper.updateFeedback(feedback);
    }
    //删除
    @Override
    public boolean deleteFeedback(int id) {
        return feedbackMapper.deleteFeedback(id);
    }
}
