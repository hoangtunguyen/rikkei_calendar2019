package com.example.RikkeiCalendar.respones;

import java.sql.Timestamp;
import java.util.List;

public class RepeatCategoryResponse {
    private  int id;
    private  String cateName;
    private Timestamp finishTime;
    private List<Integer> repeatDays;
    public RepeatCategoryResponse() {
    }

    public RepeatCategoryResponse(int id, String cateName, Timestamp finishTime, List<Integer> repeatDays) {
        this.id = id;
        this.cateName = cateName;
        this.finishTime = finishTime;
        this.repeatDays = repeatDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public List<Integer> getRepeatDays() {
        return repeatDays;
    }

    public void setRepeatDays(List<Integer> repeatDays) {
        this.repeatDays = repeatDays;
    }
}
