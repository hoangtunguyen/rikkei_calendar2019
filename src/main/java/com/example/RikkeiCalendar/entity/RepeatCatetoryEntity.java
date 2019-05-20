package com.example.RikkeiCalendar.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "repeat_category")
public class RepeatCatetoryEntity extends Auditable<String>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cate_name")
    private String categoryName;

    @Column(name = "repeat_duration")
    private int repeatDuration;
    @Column(name = "del_flag")
    private int del_flag;

    @OneToMany(mappedBy = "repeatCatetoryEntity")
    private List<CategoryTypeEntity> categoryTypeEntities;
    @OneToMany(mappedBy = "repeatCatetoryEntity")
    private List<BigTaskEntity> bigTaskEntities;

    public RepeatCatetoryEntity() {
    }

    public RepeatCatetoryEntity(String createdBy, Timestamp createdDate, String updatedBy, Timestamp updatedDate, String categoryName, int repeatDuration, int del_flag, List<CategoryTypeEntity> categoryTypeEntities, List<BigTaskEntity> bigTaskEntities) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.categoryName = categoryName;
        this.repeatDuration = repeatDuration;
        this.del_flag = del_flag;
        this.categoryTypeEntities = categoryTypeEntities;
        this.bigTaskEntities = bigTaskEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRepeatDuration() {
        return repeatDuration;
    }

    public void setRepeatDuration(int repeatDuration) {
        this.repeatDuration = repeatDuration;
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public List<CategoryTypeEntity> getCategoryTypeEntities() {
        return categoryTypeEntities;
    }

    public void setCategoryTypeEntities(List<CategoryTypeEntity> categoryTypeEntities) {
        this.categoryTypeEntities = categoryTypeEntities;
    }

    public List<BigTaskEntity> getBigTaskEntities() {
        return bigTaskEntities;
    }

    public void setBigTaskEntities(List<BigTaskEntity> bigTaskEntities) {
        this.bigTaskEntities = bigTaskEntities;
    }
}
