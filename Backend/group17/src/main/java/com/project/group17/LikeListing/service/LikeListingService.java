package com.project.group17.LikeListing.service;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.LikeListing.entity.LikeListingPojo;
import com.project.group17.LikeListing.repository.LikeListingRepository;
import com.project.group17.listings.repository.ListingsRepository;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class LikeListingService {
    @Autowired
    ListingsRepository listingsRepository;
    @Autowired
    LikeListingRepository likeListingRepository;
    public void likeListing(LikeListingPojo likeListingPojo){
        LikeListingEntity entity = new LikeListingEntity();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setUser(user);
        entity.setListingsEntity(listingsRepository.findByListingId(likeListingPojo.getListingId()));
        likeListingRepository.save(entity);
    }

    public void unlikeListing(long listingId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        likeListingRepository.deleteById(likeListingRepository.getId(user.getId(), listingId));
    }
}
