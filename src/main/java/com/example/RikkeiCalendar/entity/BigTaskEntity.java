package com.example.RikkeiCalendar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "big_task")
public class BigTaskEntity extends Auditable<String>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title",length = 50)
    private String title;

    @Column(name = "detail")
    private String detail;

    @Column(name = "location",length = 50)
    private String location;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "finish_time")
    private Timestamp finishTime;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "all_day")
    private boolean allDay=false;

    @Column(name = "status",length = 50)
    private int status;

    @OneToMany(mappedBy = "bigTaskEntity")
    private List<TaskEntity> taskEntities;

    @OneToMany(mappedBy = "taskEntity")
    private List<UserTaskEntity> userTaskEntities;

    @OneToMany(mappedBy = "bigTaskEntity")
    private List<BigUserTaskEntity> bigUserTaskEntities;
    @OneToOne
    @JoinColumn(name = "repeat_id",unique = true)
    private RepeatCatetoryEntity repeatCatetoryEntity;

    @Column(name = "del_flag",length = 10)
    private int delFlag;

    public BigTaskEntity() {
    }

    public BigTaskEntity(String createdBy, Timestamp createdDate, String updatedBy, Timestamp updatedDate, String title, String detail, String location, Timestamp startTime, Timestamp finishTime, String imageURL, boolean allDay, int status, List<TaskEntity> taskEntities, List<UserTaskEntity> userTaskEntities, List<BigUserTaskEntity> bigUserTaskEntities, RepeatCatetoryEntity repeatCatetoryEntity, int delFlag) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.title = title;
        this.detail = detail;
        this.location = location;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.imageURL = imageURL;
        this.allDay = allDay;
        this.status = status;
        this.taskEntities = taskEntities;
        this.userTaskEntities = userTaskEntities;
        this.bigUserTaskEntities = bigUserTaskEntities;
        this.repeatCatetoryEntity = repeatCatetoryEntity;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }

    public List<UserTaskEntity> getUserTaskEntities() {
        return userTaskEntities;
    }

    public void setUserTaskEntities(List<UserTaskEntity> userTaskEntities) {
        this.userTaskEntities = userTaskEntities;
    }

    public List<BigUserTaskEntity> getBigUserTaskEntities() {
        return bigUserTaskEntities;
    }

    public void setBigUserTaskEntities(List<BigUserTaskEntity> bigUserTaskEntities) {
        this.bigUserTaskEntities = bigUserTaskEntities;
    }

    public RepeatCatetoryEntity getRepeatCatetoryEntity() {
        return repeatCatetoryEntity;
    }

    public void setRepeatCatetoryEntity(RepeatCatetoryEntity repeatCatetoryEntity) {
        this.repeatCatetoryEntity = repeatCatetoryEntity;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
