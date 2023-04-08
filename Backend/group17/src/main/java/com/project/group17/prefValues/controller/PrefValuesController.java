package com.project.group17.prefValues.controller;

import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import com.project.group17.prefValues.service.PrefValuesService;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PrefValuesController {
    @Autowired
    PrefValuesService service;
    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<String> saveUserPreferences(@RequestBody List<PrefValueSaveReq> userPref){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.saveUserPreferences(user.getId(), userPref));
    }

    @CrossOrigin
    @GetMapping("/getUserPrefValues")
    public ResponseEntity<List<PrefValueSaveReq>> getUserPrefValues(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.getUserPrefValuesById(user.getId()));
    }
}
