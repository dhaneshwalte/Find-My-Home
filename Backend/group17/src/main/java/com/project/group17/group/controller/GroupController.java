package com.project.group17.group.controller;

import com.project.group17.group.entity.GroupDetailPojo;


import com.project.group17.group.entity.GroupPojo;
import com.project.group17.group.service.GroupService;
import com.project.group17.match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class GroupController {

    @Autowired
    GroupService groupService;
    @Autowired
    MatchService matchService;

    @GetMapping("/my-group")
    @CrossOrigin
    public ResponseEntity<List<Map<String, String>>> getGroupMembers(){
        return ResponseEntity.ok(matchService.getAllUserInfoAndPreferences(groupService.getGroupMembers()));
    }

    @CrossOrigin
    @GetMapping("/my-roommate-request")
    public ResponseEntity<List<Map<String, String>>> getRoommateRequest(){
        return ResponseEntity.ok(matchService.getAllUserInfoAndPreferences(groupService.getRoommateRequest()));
    }


    @GetMapping("/get-all-groups")
    @CrossOrigin
    public ResponseEntity<List<GroupPojo>> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping("/get-group")
    @CrossOrigin
    public ResponseEntity<List<Map<String, String>>> getGroup(@RequestBody GroupDetailPojo groupDetailPojo) {
        List<Map<String, String>> users =(matchService.getAllUserInfoAndPreferences(groupService.getGroupUsers(groupDetailPojo.getGroupId())));
        return ResponseEntity.ok(users);
    }
}
