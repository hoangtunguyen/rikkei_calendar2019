package com.example.RikkeiCalendar.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_team")
public class UserTeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "role_team_id")
    private RoleTeamEntity roleTeamEntity;

    @JoinColumn(name = "del_flag")
    private int delFlag;

    public UserTeamEntity() {
    }

    public UserTeamEntity(UserEntity user, TeamEntity team, RoleTeamEntity roleTeamEntity, int delFlag) {
        this.user = user;
        this.team = team;
        this.roleTeamEntity = roleTeamEntity;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    public RoleTeamEntity getRoleTeamEntity() {
        return roleTeamEntity;
    }

    public void setRoleTeamEntity(RoleTeamEntity roleTeamEntity) {
        this.roleTeamEntity = roleTeamEntity;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
