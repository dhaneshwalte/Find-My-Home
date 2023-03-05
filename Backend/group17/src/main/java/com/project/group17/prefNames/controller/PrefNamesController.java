package com.project.group17.prefNames.controller;

import com.project.group17.prefNames.entity.prefNamesEntity;
import com.project.group17.prefNames.service.PrefNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PrefNamesController {

    @Autowired
    PrefNamesService service;
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<prefNamesEntity>> getAllPrefOptions(){
        return ResponseEntity.ok(service.getAllPrefOptions());
    }

}
