package com.example.RikkeiCalendar.service;

import com.example.RikkeiCalendar.entity.*;
import com.example.RikkeiCalendar.repository.*;
import com.example.RikkeiCalendar.request.BigTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigTaskServiceImpl implements BigTaskService{
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
    @Override
    public void addTask(BigTaskRequest bigTaskRequest) {

        RepeatCatetoryEntity repeat=new RepeatCatetoryEntity();
        repeat.setCategoryName(bigTaskRequest.getCateRepeat());
        repeat.setFinishTimeRepeat(bigTaskRequest.getFinishRepeat());
        repeat.setDel_flag(CREATE_FLAG);
        RepeatCatetoryEntity repeatCate =repeatCategoryRepository.save(repeat);
        CategoryTypeEntity cate;
        BigUserTaskEntity bigUserTaskEntity;
        for (int i=0;i<bigTaskRequest.getDaysOfRepeat().size();i++){
            cate=new CategoryTypeEntity();
            cate.setRepeatCatetoryEntity(repeatCate);
            System.out.println("i= "+bigTaskRequest.getDaysOfRepeat().get(i));
            cate.setTypeRepeatEntity(typeRepeatRepository.findById(bigTaskRequest.getDaysOfRepeat().get(i)).get());
            categoryTypeRepository.save(cate);
        }


        System.out.println("Tơtal i: "+bigTaskRequest.getDaysOfRepeat().size());
        BigTaskEntity bigTaskEntity=new BigTaskEntity();
        bigTaskEntity.setTitle(bigTaskRequest.getTitle());
        bigTaskEntity.setDetail(bigTaskRequest.getDetail());
        bigTaskEntity.setLocation(bigTaskRequest.getLocation());
        bigTaskEntity.setAllDay(bigTaskRequest.isAllDay());
        bigTaskEntity.setStartTime(bigTaskRequest.getStartTime());
        bigTaskEntity.setFinishTime(bigTaskRequest.getFinishTime());
        bigTaskEntity.setImageURL(bigTaskRequest.getImageURL());
        bigTaskEntity.setStatus(bigTaskRequest.getStatus());
        // have to set value for user
        bigTaskEntity.setRepeatCatetoryEntity(repeatCate);
        BigTaskEntity bigTaskEntity1=bigTaskRepository.save(bigTaskEntity);
        for (int i=0;i<bigTaskRequest.getUserId().size();i++){
            bigUserTaskEntity=new BigUserTaskEntity();
            bigUserTaskEntity.setBigTaskEntity(bigTaskEntity1);
            bigUserTaskEntity.setUserEntity(userRepository.findById(bigTaskRequest.getUserId().get(i)).get());
            bigUserTaskRepository.save(bigUserTaskEntity);
        }

    }
}
