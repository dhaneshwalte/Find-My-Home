package com.project.group17.location.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.group17.location.entity.LocationEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class LocationRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(LocationEntity location){
        entityManager.persist(location);
    }

    public LocationEntity findByCity(String city) {
        return entityManager.find(LocationEntity.class, city);
    }
    
}
