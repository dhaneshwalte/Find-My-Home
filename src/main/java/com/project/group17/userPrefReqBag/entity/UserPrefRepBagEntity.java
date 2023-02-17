package com.project.group17.userPrefReqBag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PrefReqBag")
public class UserPrefRepBagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
