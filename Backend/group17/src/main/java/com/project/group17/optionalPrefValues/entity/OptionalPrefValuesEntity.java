//package com.project.group17.optionalPrefValues.entity;
//
//import com.project.group17.prefNames.entity.PrefNamesEntity;
//import com.project.group17.prefOptions.entity.PrefOptionsEntity;
//import com.project.group17.user.entity.User;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "optional_pref")
//public class OptionalPrefValuesEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long optionalPrefValueId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pref_option_id")
//    private PrefOptionsEntity optionalPrefOption;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pref_name_id")
//    private PrefNamesEntity optionalPrefName;
//}
