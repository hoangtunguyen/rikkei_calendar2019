package com.example.RikkeiCalendar.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_team")
public class RoleTeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "role_team_name")
    private String roleTeamName;

    @OneToMany(mappedBy = "roleTeamEntity",fetch = FetchType.EAGER)
    private List<UserTeamEntity> userTeamEntities;

    @JoinColumn(name = "del_flag")
    private int delFlag;

    public RoleTeamEntity() {
    }

    public RoleTeamEntity(String roleTeamName, List<UserTeamEntity> userTeamEntities, int delFlag) {
        this.roleTeamName = roleTeamName;
        this.userTeamEntities = userTeamEntities;
        this.delFlag = delFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleTeamName() {
        return roleTeamName;
    }

    public void setRoleTeamName(String roleTeamName) {
        this.roleTeamName = roleTeamName;
    }

    public List<UserTeamEntity> getUserTeamEntities() {
        return userTeamEntities;
    }

    public void setUserTeamEntities(List<UserTeamEntity> userTeamEntities) {
        this.userTeamEntities = userTeamEntities;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
