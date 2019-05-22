package com.example.RikkeiCalendar.entity;

public enum CategoryEnum {
    NONE ("none"),
    DAILY ("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly");
    private final String cateName;
    CategoryEnum(String cateName){
        this.cateName=cateName;
    }


}
