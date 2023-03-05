package com.project.group17.prefOptions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.group17.prefNames.entity.prefNamesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pref_options")public class PrefOptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long prefId;

    @ManyToOne()
    @JoinColumn(name = "pref_name_id", nullable = false)
    private prefNamesEntity prefName;

    @Column(nullable = false)
    private String option;

    public Long getPrefId() {
        return prefId;
    }

    public void setPrefId(Long prefId) {
        this.prefId = prefId;
    }

    @JsonBackReference
    public prefNamesEntity getPrefName() {
        return prefName;
    }

    public void setPrefName(prefNamesEntity prefName) {
        this.prefName = prefName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
