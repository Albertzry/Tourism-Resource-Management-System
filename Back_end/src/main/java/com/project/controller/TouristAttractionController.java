package com.project.controller;

import com.project.pojo.TouristAttraction;
import com.project.service.TouristAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist_attraction")
@CrossOrigin(origins = "*")
public class TouristAttractionController {

    @Autowired
    TouristAttractionService touristAttractionService;

    @GetMapping("/info")
    public List<TouristAttraction> selectAll(){
        return touristAttractionService.selectAll();
    }

    @PostMapping(value="/delete/{id}",produces="application/json;charset=utf-8")
    public void delete(@PathVariable("id") int id){
        touristAttractionService.delete(id);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody TouristAttraction touristAttraction) {
        touristAttractionService.insert(touristAttraction);
    }

    @PostMapping(value="/update",produces="application/json;charset=utf-8")
    public void update(@RequestBody TouristAttraction touristAttraction) {
        touristAttractionService.update(touristAttraction);
    }

    @GetMapping("/selectById/{id}")
    public List<TouristAttraction> selectById(@PathVariable("id") int id) {
        return touristAttractionService.selectById(id);
    }
}

