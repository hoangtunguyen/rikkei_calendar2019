package com.example.RikkeiCalendar.entity;

import javax.persistence.*;

@Entity
@Table(name = "cate_type")
public class CategoryTypeEntity extends Auditable<String>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "repeat_cate_id")
    private RepeatCatetoryEntity repeatCatetoryEntity;

    @ManyToOne
    @JoinColumn(name = "type_repeat_id")
    private TypeRepeatEntity typeRepeatEntity;

    @Column(name = "del_flag")
    private int delFlag;

    public CategoryTypeEntity() {
    }

    public CategoryTypeEntity(RepeatCatetoryEntity repeatCatetoryEntity, TypeRepeatEntity typeRepeatEntity, int delFlag) {
        this.repeatCatetoryEntity = repeatCatetoryEntity;
        this.typeRepeatEntity = typeRepeatEntity;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RepeatCatetoryEntity getRepeatCatetoryEntity() {
        return repeatCatetoryEntity;
    }

    public void setRepeatCatetoryEntity(RepeatCatetoryEntity repeatCatetoryEntity) {
        this.repeatCatetoryEntity = repeatCatetoryEntity;
    }

    public TypeRepeatEntity getTypeRepeatEntity() {
        return typeRepeatEntity;
    }

    public void setTypeRepeatEntity(TypeRepeatEntity typeRepeatEntity) {
        this.typeRepeatEntity = typeRepeatEntity;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
