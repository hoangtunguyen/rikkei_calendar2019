package com.example.RikkeiCalendar.entity;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "title")
    private String title;

    @JoinColumn(name = "detail")
    private String detail;

    @JoinColumn(name = "location")
    private String location;

    @JoinColumn(name = "start_time")
    private Timestamp startTime;

    @JoinColumn(name = "finish_time")
    private Timestamp finishTime;

    @JoinColumn(name = "image_url")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserEntity creator;

    @JoinColumn(name = "all_day")
    private boolean allDay=false;

    @JoinColumn(name = "status")
    private int status;

    @JoinColumn(name = "create_at")
    private Timestamp createAt;

    @OneToMany(mappedBy = "taskEntity")
    private List<UserTaskEntity> userTaskEntities;

    @JoinColumn(name = "del_flag")
    private int delFlag;

    public TaskEntity() {
    }

    public TaskEntity(String title, String detail, String location, Timestamp startTime, Timestamp finishTime, String imageURL, UserEntity creator, boolean allDay, int status, Timestamp createAt, List<UserTaskEntity> userTaskEntities, int delFlag) {
        this.title = title;
        this.detail = detail;
        this.location = location;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.imageURL = imageURL;
        this.creator = creator;
        this.allDay = allDay;
        this.status = status;
        this.createAt = createAt;
        this.userTaskEntities = userTaskEntities;
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

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public List<UserTaskEntity> getUserTaskEntities() {
        return userTaskEntities;
    }

    public void setUserTaskEntities(List<UserTaskEntity> userTaskEntities) {
        this.userTaskEntities = userTaskEntities;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
