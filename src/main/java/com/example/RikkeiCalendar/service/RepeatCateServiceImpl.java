package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.RepeatCatetoryEntity;
import com.example.RikkeiCalendar.repository.RepeatCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatCateServiceImpl implements RepeatCateService{
    @Autowired
    RepeatCategoryRepository repeatCategoryRepository;
    @Override
    public List<RepeatCatetoryEntity> findAll() {
        return repeatCategoryRepository.findAll();
    }
}
