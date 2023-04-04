package com.project.group17.listings.controller;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.LikeListing.repository.LikeListingRepository;
import com.project.group17.listings.repository.ListingsRepository;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.listings.service.ListingsService;


@RestController
@RequestMapping("/api/v1")

public class ListingsController {
    @Autowired
    private ListingsService listingsService;

    @Autowired
    private LikeListingRepository likeListingRepository;

    @Autowired
    private ListingsRepository listingsRepository;
    @CrossOrigin
    @PostMapping("/listing")
    public String add(@RequestBody ListingsEntity listing)
    {
        listingsService.saveListings(listing);
        return "New listing is added";

    }


    @CrossOrigin
    @GetMapping("/getAll")
    public List<ListingsEntity> list()
    {

        return listingsService.getAllListings();
    }
//    @CrossOrigin
//    @PostMapping("/likeListing")
//    public String addLikeListing(@RequestBody LikeEntity liked)
//    {
//        listingsService.addLike(liked);
//        return "current listing is liked";
//
//    }

    @CrossOrigin
    @GetMapping("/get-liked-listings")
    public List<ListingsEntity> getLikedListings() {
        //find by passing user object > groups table
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<LikeListingEntity> likeListingEntities = likeListingRepository.findByUser(user);
        List<ListingsEntity> listingsEntities = new ArrayList<>();
        for(int i = 0; i<likeListingEntities.size(); i++){
            listingsEntities.add(likeListingEntities.get(i).getListingsEntity());
        }
        return listingsEntities;
    }


}