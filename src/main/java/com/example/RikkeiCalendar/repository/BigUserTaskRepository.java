package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.BigTaskEntity;
import com.example.RikkeiCalendar.entity.BigUserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BigUserTaskRepository extends JpaRepository<BigUserTaskEntity,Integer> {
    List<BigUserTaskEntity> findAllByBigTaskEntity(BigTaskEntity bigTaskEntity);
}
