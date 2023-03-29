package com.project.group17.match.entity;

import com.project.group17.user.entity.User;
import jakarta.persistence.*;

//TODO : this is a temporary table

@Entity
@IdClass(MatchId.class)
@Table(name = "matches")
public class MatchEntity {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "liker", nullable = false)
    private User user1;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "likee", nullable = false)
    private User user2;

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public String toString() {
        return "MatchEntity{" +
                "user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
