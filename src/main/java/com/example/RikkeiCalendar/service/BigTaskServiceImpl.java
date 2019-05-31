package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.*;
import com.example.RikkeiCalendar.repository.*;
import com.example.RikkeiCalendar.request.BigTaskRequest;
import com.example.RikkeiCalendar.request.TaskRequestOnlyStatus;
import com.example.RikkeiCalendar.respones.TaskReponse;
import com.example.RikkeiCalendar.test.BigFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BigTaskServiceImpl implements BigTaskService {
    private static final int CREATE_FLAG = 0;
    @Autowired
    BigTaskRepository bigTaskRepository;
    @Autowired
    RepeatCategoryRepository repeatCategoryRepository;
    @Autowired
    TypeRepeatRepository typeRepeatRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryTypeRepository categoryTypeRepository;
    @Autowired
    BigUserTaskRepository bigUserTaskRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserTaskRepository userTaskRepository;

    @Override
    public void addTask(BigTaskRequest bigTaskRequest) {
        RepeatCatetoryEntity repeat = new RepeatCatetoryEntity();
        repeat.setCategoryName(bigTaskRequest.getCateRepeat());
        repeat.setFinishTimeRepeat(bigTaskRequest.getFinishRepeat());
        repeat.setDel_flag(CREATE_FLAG);
        RepeatCatetoryEntity repeatCate = repeatCategoryRepository.save(repeat);
        CategoryTypeEntity cate;
        BigUserTaskEntity bigUserTaskEntity;
        for (int i = 0; i < bigTaskRequest.getDaysOfRepeat().size(); i++) {
            cate = new CategoryTypeEntity();
            cate.setRepeatCatetoryEntity(repeatCate);
            System.out.println("i= " + bigTaskRequest.getDaysOfRepeat().get(i));
            cate.setTypeRepeatEntity(typeRepeatRepository.findById(bigTaskRequest.getDaysOfRepeat().get(i)).get());
            categoryTypeRepository.save(cate);
        }
        System.out.println("Tơtal i: " + bigTaskRequest.getDaysOfRepeat().size());
        BigTaskEntity bigTaskEntity = new BigTaskEntity();
        bigTaskEntity.setTitle(bigTaskRequest.getTitle());
        bigTaskEntity.setDetail(bigTaskRequest.getDetail());
        bigTaskEntity.setLocation(bigTaskRequest.getLocation());
        bigTaskEntity.setAllDay(bigTaskRequest.isAllDay());
        bigTaskEntity.setStartTime(bigTaskRequest.getStartTime());
        bigTaskEntity.setFinishTime(bigTaskRequest.getFinishTime());
        bigTaskEntity.setImageURL(bigTaskRequest.getImageURL());
        bigTaskEntity.setStatus(bigTaskRequest.getStatus());
        bigTaskEntity.setRepeatCatetoryEntity(repeatCate);
        BigTaskEntity bigTaskEntity1 = bigTaskRepository.save(bigTaskEntity);
        for (int i = 0; i < bigTaskRequest.getUserId().size(); i++) {
            bigUserTaskEntity = new BigUserTaskEntity();
            bigUserTaskEntity.setBigTaskEntity(bigTaskEntity1);
            bigUserTaskEntity.setUserEntity(userRepository.findById(bigTaskRequest.getUserId().get(i)).get());
            bigUserTaskRepository.save(bigUserTaskEntity);
        }
        addSupTask(bigTaskEntity1);

    }

    @Override
    public void saveTask(TaskRequestOnlyStatus request) {
        TaskEntity taskEntity=taskRepository.findById(request.getId()).get();
        taskEntity.setStatus(request.getStatus());
        taskRepository.save(taskEntity);
    }

    public void addSupTask(BigTaskEntity bigTaskEntity) {
        TaskEntity taskEntity;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        String startRepeat = sdf.format(bigTaskEntity.getStartTime());
        String finishRepeat = sdf.format(bigTaskEntity.getRepeatCatetoryEntity().getFinishTimeRepeat());
        int choiceTypeRepeat = bigTaskEntity.getRepeatCatetoryEntity().getCategoryName();
        BigFunction bigFunction = new BigFunction();
        List<Integer> repeatWeek = new ArrayList<>();
        RepeatCatetoryEntity repeatCatetoryEntities = bigTaskEntity.getRepeatCatetoryEntity();
        List<CategoryTypeEntity> categoryTypeEntities = categoryTypeRepository.findAllByRepeatCatetoryEntity(repeatCatetoryEntities);
        for (CategoryTypeEntity categoryTypeEntity : categoryTypeEntities) {
            repeatWeek.add(categoryTypeEntity.getTypeRepeatEntity().getType_name());
        }
        List<String> repeatTime = bigFunction.repeatBy(startRepeat, finishRepeat, repeatWeek, choiceTypeRepeat);

        Timestamp time;
        for (String repeat : repeatTime) {
            taskEntity = new TaskEntity();
            try {
                time = Timestamp.valueOf(repeat);
                taskEntity.setStartTime(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
            taskEntity.setFinishTime(bigTaskEntity.getFinishTime());
            taskEntity.setImageURL(bigTaskEntity.getImageURL());
            taskEntity.setStatus(bigTaskEntity.getStatus());
            taskEntity.setTitle(bigTaskEntity.getTitle());
            taskEntity.setDetail(bigTaskEntity.getDetail());
            taskEntity.setLocation(bigTaskEntity.getLocation());
            taskEntity.setAllDay(bigTaskEntity.isAllDay());
            taskEntity.setBigTaskEntity(bigTaskEntity);
            taskEntity.setDelFlag(bigTaskEntity.getDelFlag());

            UserTaskEntity userTaskEntity;
            List<BigUserTaskEntity> bigUserTaskEntities=bigUserTaskRepository.findAllByBigTaskEntity(bigTaskEntity);
            TaskEntity taskEntity1= taskRepository.save(taskEntity);
            for (BigUserTaskEntity bigUserTaskEntity: bigUserTaskEntities){
                userTaskEntity=new UserTaskEntity();
                userTaskEntity.setTaskEntity(taskEntity1);
                userTaskEntity.setUserInTask(bigUserTaskEntity.getUserEntity());
                userTaskRepository.save(userTaskEntity);
            }
        }
    }

    @Override
    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskEntity> findAllByStartTimeGreaterThanEqualAndStartTimeLessThan(Timestamp startTime,Timestamp maxTime) {
        return taskRepository.findAllByStartTimeGreaterThanEqualAndStartTimeLessThan(startTime,maxTime);
    }

}
