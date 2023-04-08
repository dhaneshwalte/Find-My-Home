package com.project.group17.listings.controller;
import com.project.group17.listings.service.ListingsService;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.group17.listings.entity.ListingsEntity;

@RestController
@RequestMapping("/api/v1")

public class ListingsController {
    @Autowired
    private ListingsService listingsService;
    @CrossOrigin
    @PostMapping("/listing")
    public String add(@RequestBody ListingsEntity listing) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        listing.setUser(user);
        listingsService.saveListings(listing);
        return "New listing is added";

    }

    @CrossOrigin
    @GetMapping("/getAll")
    public List<ListingsEntity> list() {
        return listingsService.getAllListings();
    }

    @CrossOrigin
    @GetMapping("/get-my-listings")
    public List<ListingsEntity> getMyListings() {
        // returns the listings posted by the user
        // find by passing user object > groups table
        return listingsService.getMyListings();
    }

    @CrossOrigin
    @GetMapping("/get-liked-listings")
    public List<ListingsEntity> getLikedListings() {
        return listingsService.getLikedListings();
    }

}