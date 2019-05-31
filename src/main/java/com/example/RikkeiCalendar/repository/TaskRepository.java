package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findAllByStartTimeGreaterThanEqualAndStartTimeLessThan(Timestamp startTime,Timestamp maxStarttime);
    List<TaskEntity> findAllByStartTimeContains(Timestamp timestamp);
}
