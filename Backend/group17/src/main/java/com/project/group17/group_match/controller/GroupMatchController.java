package com.project.group17.group_match.controller;
import com.project.group17.group.entity.GroupEntity;
import com.project.group17.group.repository.GroupRepository;
import com.project.group17.group_match.entity.GroupMatchEntity;
import com.project.group17.group_match.entity.GroupMatchPojo;
import com.project.group17.group_match.repository.GroupMatchRepository;
import com.project.group17.match.service.MatchService;
import com.project.group17.user.entity.User;
import com.project.group17.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class GroupMatchController {
    @Autowired
    GroupMatchRepository groupMatchRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    MatchService matchService;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value = "/request-group", method = RequestMethod.POST)
    public @ResponseBody void addUserRequest(@RequestBody GroupMatchPojo groupId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GroupMatchEntity entity = new GroupMatchEntity();
        entity.setUser(user);
        entity.setGroupId(groupId.getGroupId());
        groupMatchRepository.save(entity);
    }

    @GetMapping("/group-requests")
    public ResponseEntity<List<Map<String, String>>> groupRequests() {
        //find by passing user object > groups table
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int groupId = groupRepository.getGroupId(user.getId());
        //from group-match table find the user's
        List<Integer> usersID = groupMatchRepository.getUsersByGroupId(groupId);
        List<User> userList = new ArrayList<>();
        for(int i = 0; i<usersID.size(); i++){
            Optional<User> optionalUser =  userRepository.findById(usersID.get(i));
            optionalUser.ifPresent(userList::add);
        }
        System.out.println(matchService.getAllUserInfoAndPreferences(userList));
        return ResponseEntity.ok(matchService.getAllUserInfoAndPreferences(userList));
    }

}
