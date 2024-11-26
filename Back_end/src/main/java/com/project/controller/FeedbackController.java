package com.project.controller;
import com.project.pojo.Feedback;
import com.project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//feedback表接口实现
@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    //查询全部
    @GetMapping(value = "/info", produces = "application/json; charset=utf-8")
    public List<Feedback> getFeedbackInfo() {
        return feedbackService.getAllFeedbacks();
    }
    //按分数降序排序
    @GetMapping(value = "/info/scoreSort", produces = "application/json; charset=utf-8")
    public List<Feedback> getFeedbackInfoByScore() {
        return feedbackService.getAllFeedbacksByScore();
    }
    //根据name查
    @GetMapping(value = "/searchName/{name}", produces = "application/json; charset=utf-8")
    public List<Feedback> getFeedbackInfoByName(@PathVariable("name") String name) {
        return feedbackService.getFeedbackByName(name);
    }
    //根据phone查
    @GetMapping(value = "/searchPhone/{phone}", produces = "application/json; charset=utf-8")
    public List<Feedback> getFeedbackInfoByPhone(@PathVariable("phone") String phone) {
        return feedbackService.getFeedbackByPhone(phone);
    }
    //添加
    @PostMapping(value = "/add", produces = "application/json; charset=utf-8")
    public boolean addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }
    //修改
    @PostMapping(value = "/edit", produces = "application/json; charset=utf-8")
    public boolean editFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }
    //删除
    @PostMapping(value = "/delete/{id}", produces = "application/json; charset=utf-8")
    public boolean deleteFeedback(@PathVariable("id") Integer id) {
        return feedbackService.deleteFeedback(id);
    }
}
