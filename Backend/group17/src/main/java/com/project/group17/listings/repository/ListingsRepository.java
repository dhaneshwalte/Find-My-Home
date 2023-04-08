package com.project.group17.listings.repository;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingsRepository extends JpaRepository<ListingsEntity, Long> {
    @Query(value = "SELECT * FROM listings WHERE user = ?1", nativeQuery = true)
    List<ListingsEntity> getListingEntity(long user);

//    @Query(value = "SELECT * FROM listings WHERE listing_id = ?1", nativeQuery = true)
    ListingsEntity findByListingId(Long listingId);

    @Query(value = "SELECT * FROM listings", nativeQuery = true)
    List<ListingsEntity> getAllListings();

    List<ListingsEntity> findByUser(User user);
}
