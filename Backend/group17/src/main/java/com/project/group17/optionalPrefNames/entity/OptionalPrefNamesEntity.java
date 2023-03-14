//package com.project.group17.optionalPrefNames.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.project.group17.prefOptions.entity.PrefOptionsEntity;
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "optional_pref_names")
//public class OptionalPrefNamesEntity {
//
//    @Id
//    @GeneratedValue
//    @Column(name = "id")
//    private long prefID;
//
//    private String name;
//
//    private String type;
//
//    @OneToMany(mappedBy = "prefName")
//    private List<OptionalPrefNamesEntity> options;
//
//    public long getPrefID() {
//        return prefID;
//    }
//
//    public void setPrefID(long prefID) {
//        this.prefID = prefID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    @JsonManagedReference
//    public List<OptionalPrefNamesEntity> getOptions() {
//        return options;
//    }
//
//    public void setOptions(List<OptionalPrefNamesEntity> options) {
//        this.options = options;
//    }
//}
