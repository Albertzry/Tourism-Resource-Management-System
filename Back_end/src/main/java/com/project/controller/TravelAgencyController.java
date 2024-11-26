package com.project.controller;

import com.project.pojo.TravelAgency;
import com.project.service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel_agency")
@CrossOrigin(origins = "*")
public class TravelAgencyController {
    @Autowired
    TravelAgencyService travelAgencyService;
    //查全部接口
    @GetMapping(value="/info",produces = "application/json;charset=utf-8")
    public List<TravelAgency> selectAll(){
        return travelAgencyService.selectAll();
    }
    //根据id查
    @GetMapping(value="/searchById/{id}",produces = "application/json;charset=utf-8")
    public List<TravelAgency> selectById(@PathVariable("id") int id){
        return travelAgencyService.selectById(id);
    }
    //添加
    @PostMapping(value="/insert",produces = "application/json;charset=utf-8")
    public void insert(@RequestBody TravelAgency travelAgency){
        travelAgencyService.insert(travelAgency);
    }
    //修改
    @PostMapping(value="/update",produces = "application/json;charset=utf-8")
    public void update(@RequestBody TravelAgency travelAgency){
        travelAgencyService.update(travelAgency);
    }
    //删除
    @PostMapping(value="/delete/{id}",produces = "application/json;charset=utf-8")
    public void delete(@PathVariable("id") int id){
        travelAgencyService.delete(id);
    }
}
