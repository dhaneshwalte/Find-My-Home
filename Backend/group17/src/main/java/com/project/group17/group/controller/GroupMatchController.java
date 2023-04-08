package com.project.group17.group.controller;
import com.project.group17.group.entity.GroupMatchPojo;
import com.project.group17.group.service.GroupMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class GroupMatchController {
    @Autowired
    GroupMatchService groupMatchService;

    @CrossOrigin
    @RequestMapping(value = "/request-group", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity addUserRequest(@RequestBody GroupMatchPojo groupId) {
        groupMatchService.addUserRequest(groupId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @GetMapping("/group-requests")
    public ResponseEntity<List<Map<String, String>>> groupRequests() {
        return groupMatchService.groupRequests();
    }

    @CrossOrigin
    @RequestMapping(value = "/request-approval", method = RequestMethod.POST)
    public @ResponseBody void approveUserRequest(@RequestBody GroupMatchPojo userID) {
        groupMatchService.approveUserRequest(userID);
    }
}
