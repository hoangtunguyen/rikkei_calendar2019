package com.example.RikkeiCalendar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "user")
public class UserEntity extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "username",length = 50)
    private String username;

    @Column(name = "password",length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @OneToMany(mappedBy = "userEntity")
    private List<TeamEntity> teamEntityList;

    @OneToMany(mappedBy = "userEntityOfBigUserTask")
    private List<BigUserTaskEntity> bigUserTaskEntities;

    @OneToMany(mappedBy = "user")
    private List<UserTeamEntity> userTeamEntities;

    @OneToMany(mappedBy = "userInTask")
    private List<UserTaskEntity> userTaskEntities;

    @Column(name = "del_flag",length = 10)
    private int delFlag;

    public UserEntity() {
    }


    public UserEntity(String name, String username, String password, RoleEntity roleEntity, int delFlag) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleEntity = roleEntity;
        this.delFlag = delFlag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return roleEntity;
    }

    public void setRole(RoleEntity role) {
        this.roleEntity = role;
    }

    public List<TeamEntity> getTeamEntityList() {
        return teamEntityList;
    }

    public void setTeamEntityList(List<TeamEntity> teamEntityList) {
        this.teamEntityList = teamEntityList;
    }

    public List<UserTeamEntity> getUserTeamEntities() {
        return userTeamEntities;
    }

    public void setUserTeamEntities(List<UserTeamEntity> userTeamEntities) {
        this.userTeamEntities = userTeamEntities;
    }

    public List<UserTaskEntity> getUserTaskEntities() {
        return userTaskEntities;
    }

    public void setUserTaskEntities(List<UserTaskEntity> userTaskEntities) {
        this.userTaskEntities = userTaskEntities;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
