package com.project.service;

import com.project.mapper.TravelAgencyMapper;
import com.project.pojo.TravelAgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class TravelAgencyServiceImpl implements TravelAgencyService {
    @Autowired
    TravelAgencyMapper travelAgencyMapper;
    //查全部
    @Override
    public List<TravelAgency> selectAll() {
        return travelAgencyMapper.selectAll();
    }
    //根据id查
    @Override
    public List<TravelAgency> selectById(int id) {
        return travelAgencyMapper.selectById(id);
    }
    //添加
    @Override
    public void insert(TravelAgency travelAgency) {
        travelAgencyMapper.insert(travelAgency);
    }
    //修改
    @Override
    public void update(TravelAgency travelAgency) {
        travelAgencyMapper.update(travelAgency);
    }
    //删除
    @Override
    public void delete(int id) {
        travelAgencyMapper.delete(id);
    }
}
