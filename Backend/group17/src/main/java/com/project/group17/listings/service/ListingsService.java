package com.project.group17.listings.service;
import com.project.group17.listings.entity.LikeListingEntity;
import com.project.group17.listings.repository.LikeListingRepository;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.listings.repository.ListingsRepository;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ListingsService
{
    @Autowired
    private ListingsRepository listingsRepository;

    @Autowired
    private LikeListingRepository likeListingRepository;

    public ListingsEntity saveListings(ListingsEntity listing)
    {
        return listingsRepository.save(listing);
    }

    public List<ListingsEntity> getAllListings() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<LikeListingEntity> likeListingEntities = likeListingRepository.findByUser(user);
        List<ListingsEntity> allListings = listingsRepository.getAllListings();
        List<ListingsEntity> unlikedListings = new ArrayList<>();

        for (ListingsEntity listing : allListings) {
            boolean liked = false;
            for (LikeListingEntity like : likeListingEntities) {
                if (listing.equals(like.getListingsEntity())) {
                    liked = true;
                    break;
                }
            }
            if (!liked) {
                unlikedListings.add(listing);
            }
        }

        return unlikedListings;
    }


    public List<ListingsEntity> getMyListings() {
        // returns the listings posted by the user
        // find by passing user object > groups table
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return listingsRepository.findByUser(user);
    }

    public List<ListingsEntity> getLikedListings() {
        // find by passing user object > groups table
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<LikeListingEntity> likeListingEntities = likeListingRepository.findByUser(user);
        List<ListingsEntity> listingsEntities = new ArrayList<>();
        for (int i = 0; i < likeListingEntities.size(); i++) {
            listingsEntities.add(likeListingEntities.get(i).getListingsEntity());
        }
        return listingsEntities;
    }
}
