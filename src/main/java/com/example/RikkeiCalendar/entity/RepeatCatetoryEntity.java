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
    private int categoryName;

    @Column(name = "finishTimeRepeat")
    private Timestamp finishTimeRepeat;
    @Column(name = "del_flag")
    private int del_flag;

    @OneToMany(mappedBy = "repeatCatetoryEntity")
    private List<CategoryTypeEntity> categoryTypeEntities;
    @OneToOne(mappedBy = "repeatCatetoryEntity",cascade = CascadeType.ALL)
    private BigTaskEntity bigTaskEntities;

    public RepeatCatetoryEntity() {
    }

    public RepeatCatetoryEntity(String createdBy, Timestamp createdDate, String updatedBy, Timestamp updatedDate, int categoryName, Timestamp finishTimeRepeat, int del_flag, List<CategoryTypeEntity> categoryTypeEntities, BigTaskEntity bigTaskEntities) {
        super(createdBy, createdDate, updatedBy, updatedDate);
        this.categoryName = categoryName;
        this.finishTimeRepeat = finishTimeRepeat;
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

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getFinishTimeRepeat() {
        return finishTimeRepeat;
    }

    public void setFinishTimeRepeat(Timestamp finishTimeRepeat) {
        this.finishTimeRepeat = finishTimeRepeat;
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

    public BigTaskEntity getBigTaskEntities() {
        return bigTaskEntities;
    }

    public void setBigTaskEntities(BigTaskEntity bigTaskEntities) {
        this.bigTaskEntities = bigTaskEntities;
    }
}
