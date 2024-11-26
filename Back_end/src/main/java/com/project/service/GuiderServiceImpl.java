package com.project.service;

import com.project.mapper.GuiderMapper;
import com.project.pojo.Guider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class GuiderServiceImpl implements GuiderService {
    @Autowired
    GuiderMapper guiderMapper;
    //查全部实现
    @Override
    public List<Guider> listAllGuiders() {
        return guiderMapper.selectAllGuiders();
    }
    //查全部（按age降序排序）
    @Override
    public List<Guider> listAllGuidersByAge() {
        return guiderMapper.selectAllGuidersByAge();
    }
    //查全部（按work_exp降序排序）
    @Override
    public List<Guider> listAllGuidersByWorkExp() {
        return guiderMapper.selectAllGuidersByWorkExp();
    }
    //根据id查实现
    @Override
    public List<Guider> findGuiderById(int id) {
        return guiderMapper.selectGuiderById(id);
    }
    //根据name查实现
    @Override
    public List<Guider> findGuiderByName(String name) {
        return guiderMapper.selectGuiderByName(name);
    }
    //根据phone查实现
    @Override
    public List<Guider> findGuiderByPhone(String phone) {
        return guiderMapper.selectGuiderByPhone(phone);
    }
    //新增实现
    @Override
    public void insertGuider(Guider guider) {
        guiderMapper.insertGuider(guider);
    }
    //修改实现
    @Override
    public void updateGuider(Guider guider) {
        guiderMapper.updateGuider(guider);
    }
    //删除实现
    @Override
    public void deleteGuider(int id) {
        guiderMapper.deleteGuider(id);
    }
}