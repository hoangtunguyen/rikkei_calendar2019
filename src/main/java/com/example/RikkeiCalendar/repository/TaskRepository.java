package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
}
