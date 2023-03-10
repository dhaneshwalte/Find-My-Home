package com.project.group17.prefOptions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.group17.prefNames.entity.PrefNamesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pref_options")public class PrefOptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Long prefId;

    @ManyToOne()
    @JoinColumn(name = "pref_name_id", nullable = false)
    private PrefNamesEntity prefName;

    @Column(nullable = false)
    private String optionName;

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

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
