package com.project.group17.prefOptions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.group17.prefNames.entity.PrefNamesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pref_options")
public class PrefOptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long prefId;

    @ManyToOne()
    @JoinColumn(name = "pref_name_id", nullable = false)
    private PrefNamesEntity prefName;

    @Column(nullable = false)
    private String option_name;

    public Long getPrefId() {
        return prefId;
    }

    public void setPrefId(Long prefId) {
        this.prefId = prefId;
    }

    @JsonBackReference
    public PrefNamesEntity getPrefName() {
        return prefName;
    }

    public void setPrefName(PrefNamesEntity prefName) {
        this.prefName = prefName;
    }

    public String getOption() {
        return option_name;
    }

    public void setOption(String option) {
        this.option_name = option;
    }
}
