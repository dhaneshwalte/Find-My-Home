package com.project.group17.group.controller;

import com.project.group17.group.entity.GroupDetailPojo;
import com.project.group17.group.repository.GroupRepository;
import com.project.group17.match.service.MatchService;
import com.project.group17.user.entity.User;
import com.project.group17.user.repository.UserRepository;
import org.springframework.aop.AopInvocationException;

import com.project.group17.group.entity.GroupPojo;
import com.project.group17.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MatchService matchService;
    @Autowired
    GroupService service;
    @GetMapping("/my-group")
    public ResponseEntity<List<Map<String, String>>> getGroupMembers(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Integer> groupMembers = null;
        try{
            groupMembers = groupRepository.getUsersByGroupId(groupRepository.getGroupId(user.getId()));
        }catch (AopInvocationException aopInvocationException){
            return null;
        }
        groupMembers.remove(user.getId());
        List<User> myGroupMembers = new ArrayList<>();
        for(int i = 0; i<groupMembers.size(); i++){
            Optional<User> optionalUser =  userRepository.findById(groupMembers.get(i));
            optionalUser.ifPresent(myGroupMembers::add);
        }
        return ResponseEntity.ok(matchService.getAllUserInfoAndPreferences(myGroupMembers));
    }

    @GetMapping("/get-all-groups")
    public ResponseEntity<List<GroupPojo>> getGroups() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.getAllGroups(user));
    }

    @GetMapping("/get-group")
    public ResponseEntity<List<Map<String, String>>> getGroup(@RequestBody GroupDetailPojo groupDetailPojo) {
        List<Map<String, String>> users = service.getGroupUsers(groupDetailPojo.getGroupId());
        return ResponseEntity.ok(users);
    }
}
