package com.example.RikkeiCalendar.respones;

import java.sql.Timestamp;

public class RepeatCategoryResponse {
    private  int id;
    private  String cateName;
    private Timestamp finishTime;

    public RepeatCategoryResponse() {
    }

    public RepeatCategoryResponse(int id, String cateName, Timestamp finishTime) {
        this.id = id;
        this.cateName = cateName;
        this.finishTime = finishTime;
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
}
