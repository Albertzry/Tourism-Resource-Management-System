package com.project.service;

import com.project.mapper.TouristAttractionMapper;
import com.project.pojo.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class TouristAttractionServiceImpl implements TouristAttractionService {
    @Autowired
    TouristAttractionMapper touristAttractionMapper;
    @Override
    public List<TouristAttraction> selectAll() {
        return touristAttractionMapper.selectAll();
    }

    @Override
    public List<TouristAttraction> selectById(int id) {
        return touristAttractionMapper.selectById(id);
    }

    @Override
    public void delete(int id) {
        touristAttractionMapper.delete(id);
    }

    @Override
    public void insert(TouristAttraction touristAttraction) {
        touristAttractionMapper.insert(touristAttraction);
    }

    @Override
    public void update(TouristAttraction touristAttraction) {
        touristAttractionMapper.update(touristAttraction);
    }
}
