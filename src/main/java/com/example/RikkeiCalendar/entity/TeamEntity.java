package com.example.RikkeiCalendar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "team")
public class TeamEntity extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "team")
    private List<UserTeamEntity> userTeamEntities;

    @Column(name = "del_flag",length = 10)
    private int delFlag;

    public TeamEntity() {
    }

    public TeamEntity(String name, String description, UserEntity userEntity, List<UserTeamEntity> userTeamEntities, int delFlag) {
        this.name = name;
        this.description = description;
        this.userEntity = userEntity;
        this.userTeamEntities = userTeamEntities;
        this.delFlag = delFlag;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
