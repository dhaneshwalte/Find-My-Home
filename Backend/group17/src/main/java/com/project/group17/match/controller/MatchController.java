package com.project.group17.match.controller;
import com.project.group17.match.entity.MatchPojo;
import com.project.group17.user.entity.User;
import com.project.group17.match.service.MatchService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @CrossOrigin
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    public @ResponseBody void getUserId(@RequestBody MatchPojo user2) {
        matchService.getUserId(user2);
    }

    @CrossOrigin
    @GetMapping("/get-all-matches")
    public ResponseEntity<List<Map<String, String>>> register() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(matchService.getRoommateList(user));
    }

    @CrossOrigin
    @GetMapping("/likes")
    public ResponseEntity<List<Map<String, String>>> likes() {
        return matchService.likes();
    }

}
