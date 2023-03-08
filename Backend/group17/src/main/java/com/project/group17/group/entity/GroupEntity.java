package com.project.group17.group.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_groups")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;


}
