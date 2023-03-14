//package com.project.group17.optionalPrefNames.controller;
//
//import com.project.group17.optionalPrefNames.entity.OptionalPrefNamesEntity;
//import com.project.group17.optionalPrefNames.service.OptionalPrefNamesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/optionalpreferences")
//public class OptionalPrefNamesController {
//
//    @Autowired
//    OptionalPrefNamesService service;
//
//    @CrossOrigin
//    @GetMapping("/all")
//    public ResponseEntity<List<OptionalPrefNamesEntity>> getAllOptionalPrefOptions(){
//        return ResponseEntity.ok(service.getAllOptionalPrefOptions());
//    }
//
//}
