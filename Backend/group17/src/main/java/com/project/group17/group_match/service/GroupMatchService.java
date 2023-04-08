package com.project.group17.group_match.service;
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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GroupMatchService {
    @Autowired
    GroupMatchRepository groupMatchRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MatchService matchService;
    public void addUserRequest(GroupMatchPojo groupId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GroupMatchEntity entity = new GroupMatchEntity();
        entity.setUser(user);
        entity.setGroupId(groupId.getGroupId());
        groupMatchRepository.save(entity);
    }

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
    public void approveUserRequest(GroupMatchPojo userID) {
        //logged in user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //user whom we have approved
        long userId = userID.getUserId();
        long index = groupMatchRepository.getIndexByUserId(userId);
        groupMatchRepository.deleteById(index);
//        System.out.println(groupMatchRepository.deleteById(index));
        //add this user to the group
        Optional<User> optionalUser =  userRepository.findById((int) userID.getUserId());
        User newGroupMember = new User();
        if(optionalUser.isPresent()){
            newGroupMember = optionalUser.get();
        }
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupId(groupRepository.getGroupId(user.getId()));
        groupEntity.setUser(newGroupMember);
        groupEntity.setTotal_groups(groupRepository.getMaxGroupCount());
        groupRepository.save(groupEntity);
    }
}
