package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.TaskEntity;
import com.example.RikkeiCalendar.request.BigTaskRequest;
import com.example.RikkeiCalendar.request.TaskRequestOnlyStatus;
import com.example.RikkeiCalendar.respones.TaskReponse;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public interface BigTaskService {
    void addTask(BigTaskRequest bigTaskRequest);

    List<TaskEntity> getTasks();
    List<TaskEntity> findAllByStartTimeGreaterThanEqualAndStartTimeLessThan(Timestamp startTime,Timestamp maxTime);

    void saveTask(TaskRequestOnlyStatus request);
//    List<TaskEntity> findAllByStartTimeContains(Timestamp timestamp);
}
