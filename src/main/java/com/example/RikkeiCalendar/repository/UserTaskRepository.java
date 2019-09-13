package com.example.RikkeiCalendar.repository;

import com.example.RikkeiCalendar.entity.TaskEntity;
import com.example.RikkeiCalendar.entity.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTaskRepository extends JpaRepository<UserTaskEntity,Integer> {
    List<UserTaskEntity> findAllByTaskEntity(TaskEntity taskEntity);
}
