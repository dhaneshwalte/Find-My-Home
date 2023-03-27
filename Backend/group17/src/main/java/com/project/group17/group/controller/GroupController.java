package com.project.group17.group.controller;

import com.project.group17.group.entity.GroupEntity;
import com.project.group17.group.entity.GroupPojo;
import com.project.group17.group.service.GroupService;
import com.project.group17.prefValues.service.PrefValuesService;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Groups")
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping("/getAll")
    @CrossOrigin
    public ResponseEntity<List<GroupPojo>> getGroups() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.getAllGroups(user));
    }


}