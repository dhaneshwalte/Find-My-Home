package com.project.group17.profilepage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.group17.user.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProfileRepository  {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public  void saveEditUserDetails(User user) {
        entityManager.merge(user);
    }
}
