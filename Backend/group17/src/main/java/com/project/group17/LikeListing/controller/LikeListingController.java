package com.project.group17.LikeListing.controller;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.LikeListing.repository.LikeListingRepository;
import com.project.group17.listings.repository.ListingsRepository;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class LikeListingController {
    @Autowired
    ListingsRepository listingsRepository;
    @Autowired
    LikeListingRepository likeListingRepository;

    @CrossOrigin
    @RequestMapping(value = "/like-listing", method = RequestMethod.POST)
    public void likeListing(@RequestBody LikeListingPojo likeListingPojo){
        System.out.println("asdf" + likeListingPojo.getListingId());
        LikeListingEntity entity = new LikeListingEntity();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setUser(user);
        entity.setListingsEntity(listingsRepository.findByListingId(likeListingPojo.getListingId()));
        likeListingRepository.save(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/unlike-listing", method = RequestMethod.POST)
    public void unlikeListing(@RequestBody long listingId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println( "line 39" +likeListingRepository.getId(user.getId(), listingId));
        likeListingRepository.deleteById(likeListingRepository.getId(user.getId(), listingId));
    }
}
