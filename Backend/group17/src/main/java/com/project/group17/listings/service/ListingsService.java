package com.project.group17.listings.service;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.listings.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public interface ListingsService {
    public ListingsEntity saveListings(ListingsEntity listing);


    public List<ListingsEntity> getAllListings();

}
