package com.example.RikkeiCalendar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "role_team")
public class RoleTeamEntity extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role_team_name",length = 50)
    private String roleTeamName;

    @OneToMany(mappedBy = "roleTeamEntity",fetch = FetchType.EAGER)
    private List<UserTeamEntity> userTeamEntities;

    @Column(name = "del_flag",length = 10)
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
