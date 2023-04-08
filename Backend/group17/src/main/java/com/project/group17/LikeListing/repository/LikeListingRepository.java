package com.project.group17.LikeListing.repository;
import com.project.group17.LikeListing.entity.LikeListingEntity;
import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeListingRepository extends JpaRepository<LikeListingEntity, Long> {

    void deleteById(long id);

    @Query(value = "SELECT id FROM listings_liked WHERE user = ?1 AND listings = ?2", nativeQuery = true)
    long getId(long user_id, long listingsId);

    List<LikeListingEntity> findByUser(User user);

}
