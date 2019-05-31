package com.example.RikkeiCalendar.request;

public class TaskRequestOnlyStatus {
    private int id;
    private int status;

    public TaskRequestOnlyStatus() {
    }

    public TaskRequestOnlyStatus(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
