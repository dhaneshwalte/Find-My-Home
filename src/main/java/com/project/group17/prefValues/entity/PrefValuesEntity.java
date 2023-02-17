package com.project.group17.prefValues.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prefValues")
public class PrefValuesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pref_id", nullable = false)
    private Long prefId;

    public Long getPrefId() {
        return prefId;
    }

    public void setPrefId(Long prefId) {
        this.prefId = prefId;
    }
}
