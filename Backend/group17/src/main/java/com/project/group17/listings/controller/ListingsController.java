package com.project.group17.listings.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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


}