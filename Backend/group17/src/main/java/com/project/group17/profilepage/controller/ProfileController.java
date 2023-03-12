package com.project.group17.profilepage.controller;

import com.project.group17.user.entity.User;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {
    
    @CrossOrigin
    @GetMapping("/profilepage")
    public ResponseEntity<User> sayHello(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(user);
    }
    
}



// @RestController
// @RequestMapping("/api/preferences")public class PrefValuesController {
//     @Autowired
//     PrefValuesService service;
//     @CrossOrigin
//     @PostMapping("/save")
//     public ResponseEntity<String> saveUserPreferences(@RequestBody List<PrefValueSaveReq> userPref){
//         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//         return ResponseEntity.ok(service.saveUserPreferences(user.getId(), userPref));
//     }
// }