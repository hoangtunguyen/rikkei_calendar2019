package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.BigTaskEntity;
import com.example.RikkeiCalendar.repository.BigTaskRepository;
import com.example.RikkeiCalendar.repository.RepeatCategoryRepository;
import com.example.RikkeiCalendar.request.BigTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigTaskServiceImpl implements BigTaskService{
    @Autowired
    BigTaskRepository bigTaskRepository;
    @Autowired
    RepeatCategoryRepository repeatCategoryRepository;
    @Override
    public void addTask(BigTaskRequest bigTaskRequest) {
        BigTaskEntity bigTaskEntity=new BigTaskEntity();
        bigTaskEntity.setTitle(bigTaskRequest.getTitle());
        bigTaskEntity.setDetail(bigTaskRequest.getDetail());
        bigTaskEntity.setLocation(bigTaskRequest.getLocation());
        bigTaskEntity.setAllDay(bigTaskRequest.isAllDay());
        bigTaskEntity.setStartTime(bigTaskRequest.getStartTime());
        bigTaskEntity.setFinishTime(bigTaskRequest.getFinishTime());
        bigTaskEntity.setImageURL(bigTaskRequest.getImageURL());
        bigTaskEntity.setStatus(bigTaskRequest.getStatus());

        bigTaskEntity.setRepeatCatetoryEntity(repeatCategoryRepository.findById(bigTaskRequest.getTaskRepeatId()).get());
        bigTaskRepository.save(bigTaskEntity);


    }
}
