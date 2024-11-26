package com.project.service;

import com.project.pojo.TouristAttraction;

import java.util.List;

public interface TouristAttractionService {
    List<TouristAttraction> selectAll();
    List<TouristAttraction> selectById(int id);
    void delete(int id);
    void insert(TouristAttraction touristAttraction);
    void update(TouristAttraction touristAttraction);
}
