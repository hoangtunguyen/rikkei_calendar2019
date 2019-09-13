package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.TaskEntity;
import com.example.RikkeiCalendar.entity.UserTaskEntity;
import com.example.RikkeiCalendar.repository.TaskRepository;
import com.example.RikkeiCalendar.repository.UserTaskRepository;
import com.example.RikkeiCalendar.respones.TaskReponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskConvert {
    public static TaskReponse convert(TaskEntity taskEntity){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        SimpleDateFormat sdfFinish = new SimpleDateFormat("dd/MM HH:mm");
        SimpleDateFormat sdfStart = new SimpleDateFormat("HH:mm");
        List<String> users=new ArrayList<>();
        List<UserTaskEntity> userTaskEntities=taskEntity.getUserTaskEntities();


        TaskReponse reponse=new TaskReponse();
        reponse.setId(taskEntity.getId());

        reponse.setTitle(taskEntity.getTitle());
        reponse.setShortStartTime(sdfStart.format(taskEntity.getStartTime()));
        reponse.setShortFinishTime(sdfFinish.format(taskEntity.getFinishTime()));


        reponse.setStatus(taskEntity.getStatus());
        reponse.setDetail(taskEntity.getDetail());
        reponse.setImageURL(taskEntity.getImageURL());
        reponse.setStartTime(sdf.format(taskEntity.getStartTime()));
        reponse.setFinishTime(sdf.format(taskEntity.getFinishTime()));
        for (UserTaskEntity userTaskEntity:userTaskEntities ){
            users.add(userTaskEntity.getUserInTask().getName());
        }
        reponse.setUserEntities(users);
        reponse.setLocation(taskEntity.getLocation());
        return reponse;

    }
}
