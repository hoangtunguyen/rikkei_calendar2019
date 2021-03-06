package com.example.RikkeiCalendar.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "task")
public class TaskEntity extends Auditable<String> {
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

    @OneToMany(mappedBy = "taskEntity")
    private List<UserTaskEntity> userTaskEntities;

    @ManyToOne
    @JoinColumn(name = "big_task_id")
    private BigTaskEntity bigTaskEntity;

    @Column(name = "del_flag",length = 10)
    private int delFlag;

    public TaskEntity() {
    }

    public TaskEntity(String createdBy, Timestamp createdDate, String updatedBy, Timestamp updatedDate, String title, String detail, String location, Timestamp startTime, Timestamp finishTime, String imageURL, boolean allDay, int status, List<UserTaskEntity> userTaskEntities, BigTaskEntity bigTaskEntity, int delFlag) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.title = title;
        this.detail = detail;
        this.location = location;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.imageURL = imageURL;
        this.allDay = allDay;
        this.status = status;
        this.userTaskEntities = userTaskEntities;
        this.bigTaskEntity = bigTaskEntity;
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

    public List<UserTaskEntity> getUserTaskEntities() {
        return userTaskEntities;
    }

    public void setUserTaskEntities(List<UserTaskEntity> userTaskEntities) {
        this.userTaskEntities = userTaskEntities;
    }

    public BigTaskEntity getBigTaskEntity() {
        return bigTaskEntity;
    }

    public void setBigTaskEntity(BigTaskEntity bigTaskEntity) {
        this.bigTaskEntity = bigTaskEntity;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
