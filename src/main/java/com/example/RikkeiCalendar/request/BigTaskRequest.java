package com.example.RikkeiCalendar.request;

import java.sql.Timestamp;

public class BigTaskRequest {
    private int id;
    private String title;
    private String detail;
    private String location;
    private Timestamp startTime;
    private Timestamp finishTime;
    private String imageURL;
    private boolean allDay;
    private int status;
    private int taskRepeatId;


    public BigTaskRequest() {
    }

    public BigTaskRequest(int id, String title, String detail, String location, Timestamp startTime, Timestamp finishTime, String imageURL, boolean allDay, int status, int taskRepeatId) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.location = location;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.imageURL = imageURL;
        this.allDay = allDay;
        this.status = status;
        this.taskRepeatId = taskRepeatId;
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

    public int getTaskRepeatId() {
        return taskRepeatId;
    }

    public void setTaskRepeatId(int taskRepeatId) {
        this.taskRepeatId = taskRepeatId;
    }
}
