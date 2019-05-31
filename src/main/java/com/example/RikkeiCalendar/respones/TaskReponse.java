package com.example.RikkeiCalendar.respones;

import java.util.List;

public class TaskReponse {
    private int id;
    private String title;
    private String location;
    private int status;
    private String shortStartTime;
    private String shortFinishTime;
    private String startTime;
    private String finishTime;
    private List<String> userEntities;

    private String detail;
    private String imageURL;
    public TaskReponse() {
    }

    public TaskReponse(int id, String title, String location, int status, String shortStartTime, String shortFinishTime, String startTime, String finishTime, List<String> userEntities, String detail, String imageURL) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.status = status;
        this.shortStartTime = shortStartTime;
        this.shortFinishTime = shortFinishTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.userEntities = userEntities;
        this.detail = detail;
        this.imageURL = imageURL;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShortStartTime() {
        return shortStartTime;
    }

    public void setShortStartTime(String shortStartTime) {
        this.shortStartTime = shortStartTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public List<String> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<String> userEntities) {
        this.userEntities = userEntities;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getShortFinishTime() {
        return shortFinishTime;
    }

    public void setShortFinishTime(String shortFinishTime) {
        this.shortFinishTime = shortFinishTime;
    }
}
