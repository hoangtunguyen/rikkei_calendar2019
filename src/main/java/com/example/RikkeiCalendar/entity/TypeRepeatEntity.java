package com.example.RikkeiCalendar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_repeat")
public class TypeRepeatEntity extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private int type_name;

    @OneToMany(mappedBy = "typeRepeatEntity")
    private List<CategoryTypeEntity> categoryTypeEntities;

    @Column(name = "del_flag")
    private int delFlag;

    public TypeRepeatEntity() {
    }

    public TypeRepeatEntity(int type_name, List<CategoryTypeEntity> categoryTypeEntities, int delFlag) {
        this.type_name = type_name;
        this.categoryTypeEntities = categoryTypeEntities;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_name() {
        return type_name;
    }

    public void setType_name(int type_name) {
        this.type_name = type_name;
    }

    public List<CategoryTypeEntity> getCategoryTypeEntities() {
        return categoryTypeEntities;
    }

    public void setCategoryTypeEntities(List<CategoryTypeEntity> categoryTypeEntities) {
        this.categoryTypeEntities = categoryTypeEntities;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
