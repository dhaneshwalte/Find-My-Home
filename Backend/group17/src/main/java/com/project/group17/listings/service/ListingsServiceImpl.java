package com.project.group17.listings.service;
import com.project.group17.listings.entity.ListingsEntity;
import com.project.group17.listings.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListingsServiceImpl implements ListingsService
{
    @Autowired
    private ListingsRepository listingsRepository;

    @Override
    public ListingsEntity saveListings(ListingsEntity listing)
    {
        return listingsRepository.save(listing);
    }

    @Override
    public List<ListingsEntity> getAllListings()
    {
        return listingsRepository.findAll();
    }
}
