package com.example.RikkeiCalendar.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_task")
public class UserTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userInTask;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

    public UserTaskEntity() {
    }

    public UserTaskEntity(UserEntity userInTask, TaskEntity taskEntity) {
        this.userInTask = userInTask;
        this.taskEntity = taskEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUserInTask() {
        return userInTask;
    }

    public void setUserInTask(UserEntity userInTask) {
        this.userInTask = userInTask;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
