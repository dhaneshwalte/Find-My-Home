package com.project.group17.match.controller;

import com.project.group17.group.service.GroupService;
import com.project.group17.match.entity.MatchEntity;
import com.project.group17.match.entity.MatchPojo;
import com.project.group17.match.repository.MatchRepository;
import com.project.group17.user.entity.User;
import com.project.group17.user.repository.UserRepository;
import com.project.group17.match.service.MatchService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MatchController {
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    GroupService groupService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private MatchService matchService;

    @CrossOrigin
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public @ResponseBody void getUserId(@RequestBody MatchPojo user2) {
        MatchEntity entity = new MatchEntity();

        User liker = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalLikee = userRepository.findById(user2.getUser2ID());
        User likee = optionalLikee.get();
        entity.setUser1(liker);
        entity.setUser2(likee);
        matchRepository.save(entity);
        List<MatchEntity> matches = null;
        matches = matchRepository.findByUser1(likee);
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
            if (matches.get(i).getUser2().getId().equals(liker.getId())) {
                groupService.saveGroup(liker, likee);
                break;
            }
        }
    }

    @CrossOrigin
    @GetMapping("/get-all-matches")
    public ResponseEntity<List<Map<String, String>>> register() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(matchService.getRoommateList(user));
    }

    // @GetMapping("/likes")
    // public ResponseEntity<List<User>> likes() {
    //     User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     List<MatchEntity> entities = null;
    //     entities = matchRepository.findByUser1(currentUser);
    //     List<User> likes = new ArrayList<>();
    //     for (int i = 0; i < entities.size(); i++) {
    //         likes.add(entities.get(i).getUser2());
    //     }
    //     return ResponseEntity.ok(likes);
    // }

    @CrossOrigin
    @GetMapping("/likes")
    public ResponseEntity<List<Map<String, String>>> likes() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MatchEntity> entities = null;
        entities = matchRepository.findByUser1(currentUser);
        List<User> likes = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            likes.add(entities.get(i).getUser2());
        }
        for(User u: likes){
            System.out.println(u);
        }
        return ResponseEntity.ok(matchService.getAllUserInfoAndPreferences(likes));
    }

}
