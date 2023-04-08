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

    public List<ListingsEntity> getAllListings()
    {
        List<ListingsEntity> listingsEntities;
        List<ListingsEntity> listingsLiked = new ArrayList<>();

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        listing likes of the user have
        List<LikeListingEntity> likeListingEntities = likeListingRepository.findByUser(user);
        for(int i =0 ; i<likeListingEntities.size();i++){
            listingsLiked.add(likeListingEntities.get(i).getListingsEntity());
        }
        //all the listings
        listingsEntities = listingsRepository.getAllListings();

        for(int i = 0; i<listingsLiked.size();i++){
            if(listingsEntities.contains(listingsLiked.get(i))){
                listingsEntities.remove(listingsLiked.get(i));
            }
        }
        return listingsEntities;
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
