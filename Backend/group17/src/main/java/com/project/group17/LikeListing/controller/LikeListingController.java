package com.project.group17.LikeListing.controller;
import com.project.group17.LikeListing.entity.LikeListingPojo;
import com.project.group17.LikeListing.service.LikeListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LikeListingController {
    @Autowired
    LikeListingService likeListingService;

    @CrossOrigin
    @RequestMapping(value = "/like-listing", method = RequestMethod.POST)
    public ResponseEntity likeListing(@RequestBody LikeListingPojo likeListingPojo){
        likeListingService.likeListing(likeListingPojo);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/unlike-listing", method = RequestMethod.POST)
    public ResponseEntity unlikeListing(@RequestBody long listingId){
        likeListingService.unlikeListing(listingId);
        return ResponseEntity.ok().build();
    }
}
