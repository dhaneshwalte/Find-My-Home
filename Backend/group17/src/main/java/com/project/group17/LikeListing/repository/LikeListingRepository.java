package com.project.group17.LikeListing.repository;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeListingRepository extends JpaRepository<LikeListingEntity, Long> {

    void deleteById(long id);

    @Query(value = "SELECT id FROM listings_liked WHERE user = ?1 AND listings = ?2", nativeQuery = true)
    long getId(long user_id, long listingsId);

    List<LikeListingEntity> findByUser(User user);

//    @Query(value = "SELECT listings FROM liked_listings WHERE user = ?1", nativeQuery = true)
//    Integer getLikedListings(User user);

}
