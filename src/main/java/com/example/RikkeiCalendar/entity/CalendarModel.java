package com.example.RikkeiCalendar.entity;

public class CalendarModel {
    private int id;
    private String dayOfWeek; //Monday
    private String date;        // 25
    private String month;       //5
    private String year;        //2019

    public CalendarModel() {
    }

    public CalendarModel(int id, String dayOfWeek, String date, String month, String year) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
