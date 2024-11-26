package com.project.controller;

import com.project.pojo.Guider;
import com.project.service.GuiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
//guiders表对应接口
@RestController
@RequestMapping("/guider")
@CrossOrigin(origins = "*")
public class GuiderController {
    @Autowired
    GuiderService guiderService;
    //查全部接口
    @GetMapping(value="/info",produces="application/json;charset=utf-8")
    public List<Guider> listAllGuiders(){
        return guiderService.listAllGuiders();
    }
    //按age降序排序接口
    @GetMapping(value="/info/sortByAge",produces="application/json;charset=utf-8")
    public List<Guider> listAllGuidersByAge() {
        return guiderService.listAllGuidersByAge();
    }
    //按work_exp降序排序接口
    @GetMapping(value="/info/sortByWorkExp",produces="application/json;charset=utf-8")
    public List<Guider> listAllGuidersByWorkExp() {
        return guiderService.listAllGuidersByWorkExp();
    }
    //根据id查接口
    @GetMapping(value="/info/searchById/{id}",produces="application/json;charset=utf-8")
    public List<Guider> findGuiderById(@PathVariable("id") int id){
        return guiderService.findGuiderById(id);
    }
    //根据name查接口
    @GetMapping(value="/info/searchByName/{name}",produces="application/json;charset=utf-8")
    public List<Guider> findGuiderByName(@PathVariable("name") String name){
        return guiderService.findGuiderByName(name);
    }
    //根据phone查接口
    @GetMapping(value="/info/searchByPhone/{phone}",produces="application/json;charset=utf-8")
    public List<Guider> findGuiderByPhone(@PathVariable("phone") String phone){
        return guiderService.findGuiderByPhone(phone);
    }
    //新增接口
    @PostMapping(value="/insert",produces="application/json;charset=utf-8")
    public void insertGuider(@RequestBody Guider guider){
        guiderService.insertGuider(guider);
    }
    //更新接口
    @PostMapping(value="/update",produces="application/json;charset=utf-8")
    public void updateGuider(@RequestBody Guider guider){
        guiderService.updateGuider(guider);
    }
    //删除接口
    @PostMapping(value="/delete/{id}",produces="application/json;charset=utf-8")
    public void deleteGuider(@PathVariable("id") int id){
        guiderService.deleteGuider(id);
    }
}
