package com.project.group17.prefOptions.controller;

import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefOptions.service.PrefOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pref-option")
public class PrefOptionsController {
    @Autowired
    PrefOptionsService service;
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<PrefOptionsEntity>> getAllPrefOptions(){
        return ResponseEntity.ok(service.getAllPrefOptions());
    }
}
