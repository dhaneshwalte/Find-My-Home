package com.project.group17.prefNames.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pref_names")
public class PrefNamesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long prefId;

    private String name;

    private String type;

    private Boolean isRequired;

    @OneToMany(mappedBy = "prefName")
    private List<PrefOptionsEntity> options;


    public Boolean getIs_required() {
        return isRequired;
    }

    public void setIs_required(Boolean is_required) {
        this.isRequired = is_required;
    }

    public Long getPrefId() {
        return prefId;
    }

    public void setPrefId(Long prefId) {
        this.prefId = prefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonManagedReference
    public List<PrefOptionsEntity> getOptions() {
        return options;
    }


    public void setOptions(List<PrefOptionsEntity> options) {
        this.options = options;
    }
}