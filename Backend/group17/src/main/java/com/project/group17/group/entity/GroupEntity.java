package com.project.group17.group.entity;
import com.project.group17.user.entity.User;
import jakarta.persistence.*;
@Entity
@Table(name="groups")
public class GroupEntity {
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer index;
    private long groupId;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    private int total_groups;
    public long getGroupId() {
        return groupId;
    }
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    public long getTotal_groups() {
        return total_groups;
    }
    public void setTotal_groups(int total_groups) {
        this.total_groups = total_groups;
    }
}
