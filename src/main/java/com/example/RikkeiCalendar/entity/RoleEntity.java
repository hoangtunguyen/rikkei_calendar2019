package com.example.RikkeiCalendar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roleEntity",fetch = FetchType.LAZY)
    private List<UserEntity> users;

    @Column(name = "del_flag")
    private int delFlag;

    public RoleEntity() {
    }

    public RoleEntity(String roleName, int delFlag) {
        this.roleName = roleName;
        this.delFlag = delFlag;
    }

    public RoleEntity(String roleName, List<UserEntity> users, int delFlag) {
        this.roleName = roleName;
        this.users = users;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
