package com.project.group17.userPrefOptBag.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userPrefOptBag")
public class UserPrefOptBagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prefID;

    public Long getPrefID() {
        return prefID;
    }

    public void setPrefID(Long prefID) {
        this.prefID = prefID;
    }
}
