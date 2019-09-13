package com.example.RikkeiCalendar.entity;

import javax.persistence.*;

@Entity
@Table(name = "big_user_task")
public class BigUserTaskEntity extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntityOfBigUserTask;

    @ManyToOne
    @JoinColumn(name = "big_task_id")
    private BigTaskEntity bigTaskEntity;

    public BigUserTaskEntity() {
    }

    public BigUserTaskEntity(UserEntity userEntityOfBigUserTask, BigTaskEntity bigTaskEntity) {
        this.userEntityOfBigUserTask = userEntityOfBigUserTask;
        this.bigTaskEntity = bigTaskEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntityOfBigUserTask;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntityOfBigUserTask = userEntity;
    }

    public BigTaskEntity getBigTaskEntity() {
        return bigTaskEntity;
    }

    public void setBigTaskEntity(BigTaskEntity bigTaskEntity) {
        this.bigTaskEntity = bigTaskEntity;
    }
}
