package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.CategoryTypeEntity;
import com.example.RikkeiCalendar.entity.RepeatCatetoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryTypeRepository extends JpaRepository<CategoryTypeEntity,Integer> {
    List<CategoryTypeEntity> findAllByRepeatCatetoryEntity(RepeatCatetoryEntity repeatCatetoryEntity);
}
