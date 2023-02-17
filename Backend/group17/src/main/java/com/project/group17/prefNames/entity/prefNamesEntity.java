package com.project.group17.prefNames.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prefNames")
public class prefNamesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prefId;

    public Long getPrefId() {
        return prefId;
    }

    public void setPrefId(Long prefId) {
        this.prefId = prefId;
    }
}
